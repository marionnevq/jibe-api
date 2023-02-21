package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    
}
