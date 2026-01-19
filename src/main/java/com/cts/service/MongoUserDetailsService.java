package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.model.UserAccount;
import com.cts.repository.UserAccountRepository;

@Service
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository repository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    // 🔐 Used by Spring Security during login
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAccount user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole())
                )
                .build();
    }

    // 📝 Register new user
    public UserAccount register(UserAccount user) {

        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // BCrypt encryption
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        // normalize role
        user.setRole(user.getRole().toUpperCase());

        return repository.save(user);
    }
}
