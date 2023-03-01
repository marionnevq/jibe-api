package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Follow;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FollowRepository extends JpaRepository<Follow, Integer> {
    Optional<Follow> findByFollower_IdAndFollowee_Username(Integer id, String username);
    boolean existsByFollowerAndFollowee(User follower, User followee);
    long countByFollower(User follower);
    long countByFollowee(User followee);
    long countByFollowee_Username(String username);
    List<Follow> findByFollower_Email(String email);

    List<Follow> findByFollower_IdOrderByFollower_FirstnameDesc(Integer id);
    Optional<Follow> findByFollower_UsernameStartsWith(String username);
    Optional<Follow> findByFollowID(Integer followID);
    List<Follow> findByFollower_Username(String username);
}
