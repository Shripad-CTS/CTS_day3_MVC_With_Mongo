package com.cts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;
import com.cts.service.EmployeeService;



@RestController
@RequestMapping("/auth")
public class AuthController {

@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private PasswordEncoder passwordEncoder;

@PostMapping("/change-password")
public ResponseEntity<?> changePassword(
        @RequestBody Map<String, String> payload,
        Authentication authentication) {

    if (authentication == null ||
        authentication instanceof AnonymousAuthenticationToken) {
        return ResponseEntity.status(401).build();
    }

    String email = authentication.getName();
    Employee employee = employeeRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    String newPassword = payload.get("newPassword");

    employee.setPassword(passwordEncoder.encode(newPassword));
    employee.setFirstLogin(false);

    employeeRepository.save(employee);

    return ResponseEntity.ok("Password changed");
}


    @GetMapping("/me")
    public ResponseEntity<?> currentUser(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED)
                                 .body("Not authenticated");
        }
        return ResponseEntity.ok(authentication.getPrincipal());
    }
    
    @GetMapping("/profile")
    public ResponseEntity<?> profile(Authentication authentication) {

        if (authentication == null ||
            authentication instanceof AnonymousAuthenticationToken) {

            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED)
                                 .body("Not authenticated");
        }

        String email = authentication.getName();

        Employee employee = employeeRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setPassword(null);

        return ResponseEntity.ok(employee);
    }

}
