package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.ssglobal.revalida.jibe.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsernameLikeIgnoreCase(String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    
}
