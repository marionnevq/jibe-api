package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Follow;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FollowRepository extends JpaRepository<Follow, Integer> {

    List<Follow> findByFollower_IdOrderByFollower_FirstnameDesc(Integer id);
    Optional<Follow> findByFollower_UsernameStartsWith(String username);
    Optional<Follow> findByFollowID(Integer followID);
    List<Follow> findByFollower_Username(String username);
}
