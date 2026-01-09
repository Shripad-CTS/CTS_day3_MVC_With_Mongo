package com.cts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeRepository.save(employee);
		
	}

	public Employee getEmployee(String id) {
		return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with This ID"+id));
	}

	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);
	}

}
