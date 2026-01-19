package com.cts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;


@CrossOrigin(
	    origins = "http://localhost:4200"
	)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class); 
	
	@GetMapping("/EmployeeList")
	public ResponseEntity<List<Employee>> getEmployeeList() {
		log.info("Fetching all Employee");
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	@GetMapping("/EmployeeDetails/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String id){
		log.info("Fetching detail of Employee ID"+ id);
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@PostMapping("/saveForm")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		log.info("adding detail of Employee to Database"+ employee);
		Employee savedEmployee=employeeService.saveEmployee(employee);
		return ResponseEntity.ok(savedEmployee);
	}
	
	@GetMapping("/forceError")
	public String forceError() {
		log.debug("Trying the exception manually");
	    throw new EmployeeNotFoundException("FORCED EXCEPTION TEST");
	}
	
	
	
	
	
	@GetMapping("/search")
	public Page<Employee> searchEmployee(
			@RequestParam(required=false) String search,
			@RequestParam(required=false) String department,
			@RequestParam(required=false) String role,
			
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="10") int size,
			@RequestParam(defaultValue="name") String sortBy,
			@RequestParam(defaultValue="asc") String direction
			){
		log.info("Searching the specified details");
		Sort sort;
		if(direction.equals("desc")) {
			sort= Sort.by(sortBy).descending();
		}else {
			sort=Sort.by(sortBy).ascending();
		}
	
		Pageable  pageable= PageRequest.of(page, size,sort);
		return employeeService.searchEmployees(search,department,role,pageable);
	}

	@GetMapping("/export/csv")
	public ResponseEntity<Void> exportEmployeeAsCSV(
			@RequestParam(required=false) String search,
			@RequestParam(required=false) String department,
			@RequestParam(required=false) String role,
			@RequestParam(defaultValue="name") String sortBy,
			@RequestParam(defaultValue="asc") String direction,
			HttpServletResponse response
			) throws IOException{
		
		log.info("Creating a CSV file");
	List<Employee> employees=employeeService.searchEmployeesforExport(search, department, role, sortBy, direction);
	response.setContentType("text/csv");
	   response.setHeader(
		        "Content-Disposition",
		        "attachment; filename=employees.csv"
		    );
	   PrintWriter writer= response.getWriter();
	   
	   writer.println("name,jobTitle,department,role,salary,gender,email,address,mobileNo");
	   
	   for(Employee e:employees) {
		   writer.println(
				   e.getName()+","+
				   e.getJobTitle()+","+
				   e.getDepartment()+","+
				   e.getRole()+","+
				   e.getSalary()+","+
				   e.getGender()+","+
				   e.getEmail()+","+
				   e.getAddress()+","+
				   e.getMobileNo()
				   );
	   }
	   
	   writer.flush();
	   writer.close();
	 return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable String id) {
		log.info("deleting employee");
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable String id,@Valid @RequestBody Employee employee){
		log.info("updating employee with id "+id);
		return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
	}
	
	
}
