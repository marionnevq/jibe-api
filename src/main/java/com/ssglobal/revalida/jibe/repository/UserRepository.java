package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
