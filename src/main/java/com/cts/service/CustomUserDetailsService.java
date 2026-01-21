package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee= employeeRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user Not found"));
		 return User.builder()
	                .username(employee.getEmail())
	                .password(employee.getPassword())
	                .authorities("ROLE_" + employee.getRole().toUpperCase())
	                .build();
				
	}
}
