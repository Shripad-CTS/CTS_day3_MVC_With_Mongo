package com.cts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.cts.model.Employee;
import com.cts.model.UserAccount;
import com.cts.repository.EmployeeRepository;
import com.cts.repository.UserAccountRepository;
import com.cts.service.EmployeeUserDetailsService;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private UserAccountRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAccount req) {

        Employee emp = employeeRepo.findByEmail(req.getEmail())
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (userRepo.existsByEmail(req.getEmail())) {
            return ResponseEntity.status(409).body("Already registered");
        }

        req.setRole(emp.getRole().toUpperCase()); // <-- force role from Employee
        req.setPassword(encoder.encode(req.getPassword()));

        return ResponseEntity.ok(userRepo.save(req));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(Authentication auth) {
        return ResponseEntity.ok(auth.getPrincipal());
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        if (auth == null) {
            return ResponseEntity.status(401).body("Not logged in");
        }
        return ResponseEntity.ok(auth.getPrincipal());
    }
    
    @GetMapping("/profile")
    public ResponseEntity<Employee> myProfile(Authentication auth) {

        String email = auth.getName(); // logged in email

        Employee emp = employeeRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        return ResponseEntity.ok(emp);
    }

}
