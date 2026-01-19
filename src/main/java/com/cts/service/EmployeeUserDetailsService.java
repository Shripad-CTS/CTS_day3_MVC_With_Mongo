package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.model.UserAccount;
import com.cts.repository.EmployeeRepository;
import com.cts.repository.UserAccountRepository;
@Service
public class EmployeeUserDetailsService implements UserDetailsService {

   

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @Autowired
    private UserAccountRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) {

        UserAccount user = repo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not registered"));

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole())
                .build();
    }

    // Register only if Employee exists
//    public UserAccount register(UserAccount user) {
//
//        empRepo.findByEmail(user.getEmail())
//            .orElseThrow(() ->
//                new RuntimeException("Not a company employee"));
//
//        if(repo.existsByEmail(user.getEmail()))
//            throw new RuntimeException("User already exists");
//
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setRole(user.getRole().toUpperCase());
//
//        return repo.save(user);
//    }
}
