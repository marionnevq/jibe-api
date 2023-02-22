package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    List<User> findByUsernameLikeIgnoreCase(String username);
    Optional<User> findByEmail(String email);

//    @Override
//    Optional<User> findById(Integer integer);
//    List<User> findByUsernameLikeIgnoreCase(String username);
//
//    boolean existsByEmail(String email);
//    boolean existsByUsername(String username);
//    Optional<User> findByUsername(String username);
//
//    Optional<User> findByEmail(String email);
}