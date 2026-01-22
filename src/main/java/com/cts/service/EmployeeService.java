package com.cts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
    public  PasswordEncoder passwordEncoder;


	Logger log = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> getAllEmployee() {
		log.info("Fetching all the employee");
		return employeeRepository.findAll();

	}

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.debug("Trying to save Employee");
		
		employee.setPassword(passwordEncoder.encode("password"));
		employee.setFirstLogin(true);
		return employeeRepository.save(employee);

	}
	
	 public Employee findByEmail(String email) {
	        return employeeRepository.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("Invalid email"));
	    }

	public Employee getEmployee(String id) {
		log.debug("Trying to get Employee with ID" + id);
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with This ID" + id));

	}

	public void deleteEmployee(String id) {
		if (!employeeRepository.existsById(id)) {
			log.debug("Trying to delete Employee with ID" + id);
			throw new EmployeeNotFoundException("Employee not found with this ID " + id);

		}
		log.debug("Succussfully to delete Employee with ID" + id);
		employeeRepository.deleteById(id);
	}

	public Page<Employee> searchEmployees(String search, String department, String role, Pageable pageable) {
		log.debug("Filetring the Employee data");
		Query query = new Query();

		if (search != null && !search.isEmpty()) {
			query.addCriteria(new Criteria().orOperator(Criteria.where("name").regex(search, "i"),
					Criteria.where("email").regex(search, "i")));
		}
		if (department != null && !department.isEmpty()) {
			query.addCriteria(Criteria.where("department").is(department));
		}
		if (role != null && !role.isEmpty()) {
			query.addCriteria(Criteria.where("role").is(role));
		}

		query.with(pageable);

		List<Employee> employees = mongoTemplate.find(query, Employee.class);
		Long count = mongoTemplate.count(query.skip(0).limit(0), Employee.class);
		return new PageImpl<>(employees, pageable, count);
	}

	public List<Employee> searchEmployeesforExport(String search, String department, String role, String sortBy,
			String direction) {
		log.debug("Trying to export data as csv");
		Query query = new Query();

		if (search != null && !search.isEmpty()) {
			query.addCriteria(new Criteria().orOperator(Criteria.where("name").regex(search, "i"),
					Criteria.where("email").regex(search, "i")));
		}
		if (department != null && !department.isEmpty()) {
			query.addCriteria(Criteria.where("department").is(department));
		}
		if (role != null && !role.isEmpty()) {
			query.addCriteria(Criteria.where("role").is(role));
		}
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		query.with(sort);
		return mongoTemplate.find(query, Employee.class);

	}
	public Employee updateEmployee(String id,Employee employee) {
		Employee updateEmp= employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with ID"+id));
		updateEmp.setName(employee.getName());
		updateEmp.setDepartment(employee.getDepartment());
		updateEmp.setAddress(employee.getAddress());
		updateEmp.setGender(employee.getGender());
		updateEmp.setJobTitle(employee.getJobTitle());
		updateEmp.setMobileNo(employee.getMobileNo());
		updateEmp.setEmail(employee.getEmail());
		updateEmp.setRole(employee.getRole());
		updateEmp.setSalary(employee.getSalary());
		return employeeRepository.save(updateEmp);
	}

}
