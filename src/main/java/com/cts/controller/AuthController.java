//package com.cts.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import com.cts.model.UserAccount;
//import com.cts.service.MongoUserDetailsService;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:4200")
//public class AuthController {
//
//    @Autowired
//    private MongoUserDetailsService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody UserAccount user) {
//        return ResponseEntity.ok(service.register(user));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(Authentication authentication) {
//        return ResponseEntity.ok(authentication.getPrincipal());
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        SecurityContextHolder.clearContext();
//        return ResponseEntity.ok("Logged out successfully");
//    }
//
//    @GetMapping("/me")
//    public ResponseEntity<?> currentUser(Authentication authentication) {
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED)
//                                 .body("Not authenticated");
//        }
//        return ResponseEntity.ok(authentication.getPrincipal());
//    }
//}
