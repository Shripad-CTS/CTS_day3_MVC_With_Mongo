package com.cts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return employeeRepository.findById(id).orElse(null);
	}

	public void deleteEmployee(String id) {
		employeeRepository.deleteById(id);
	}

}
