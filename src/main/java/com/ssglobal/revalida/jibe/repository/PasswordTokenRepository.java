package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.PasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordTokenRepository extends JpaRepository<PasswordToken, Integer> {
    boolean existsByEmail(String email);
    Optional<PasswordToken> findByToken(String token);
    boolean existsByToken(String token);
}