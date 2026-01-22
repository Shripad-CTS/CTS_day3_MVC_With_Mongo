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


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class); 
	
	 @GetMapping("/admin/getAllEmployee")
	    public List<Employee> AllEmployee() {
		 
	        return employeeService.getAllEmployee();
	    }
	 
	 @PostMapping("/admin/addEmployee")
	 public Employee addEmployee(@Valid @RequestBody Employee employee) {
		 
		 
		return employeeService.saveEmployee(employee);
		 
	 }
	 
	 @DeleteMapping("/admin/deleteEmployee/{id}")
	 public void deleteEmployee(@PathVariable String id) {
		 employeeService.deleteEmployee(id);
	 }
	 
	 @PutMapping("/admin/updateEmployee/{id}")
		 public Employee updateEmployee(@Valid @RequestBody Employee employee,@PathVariable String id) {
		 return employeeService.updateEmployee(id, employee);
	 }
	 
	 @GetMapping("/admin/getEmployee/{id}")
	 public Employee getEmployee(@PathVariable String id) {
		 return employeeService.getEmployee(id);
	 }
	 
	 @GetMapping("/admin/searchEmployee")
	 public Page<Employee> searchEmployee(    @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "10") int size,
		        @RequestParam(defaultValue = "name") String sortBy,
		        @RequestParam(defaultValue = "asc") String sortDir,
		        @RequestParam(required = false) String search,
		        @RequestParam(required = false) String department,
		        @RequestParam(required = false) String role){
		Sort sort= sortDir.equals("asc")?
				Sort.by(sortBy).ascending():
					Sort.by(sortBy).descending();
		Pageable pageable= PageRequest.of(page, size, sort);
		return employeeService.searchEmployees(search, department, role, pageable);
		
	 }
	 
	
}
