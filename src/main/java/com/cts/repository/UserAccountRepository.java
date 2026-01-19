package com.cts.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.model.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {
    Optional<UserAccount> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);
}
