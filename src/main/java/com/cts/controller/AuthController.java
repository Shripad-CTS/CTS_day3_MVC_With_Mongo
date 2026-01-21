package com.cts.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {



//	@PostMapping("/login")
//	public ResponseEntity<?> login() {
//	    Map<String, Object> response = new HashMap<>();
//	    response.put("message", "Login disabled");
//	    response.put("success", true);
//	    return ResponseEntity.ok(response);
//	}
//
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        SecurityContextHolder.clearContext();
//        return ResponseEntity.ok("Logged out successfully");
//    }

    @GetMapping("/me")
    public ResponseEntity<?> currentUser(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED)
                                 .body("Not authenticated");
        }
        return ResponseEntity.ok(authentication.getPrincipal());
    }
}
