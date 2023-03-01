package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Likes;

import java.util.Optional;


public interface LikesRepository extends JpaRepository<Likes, Integer> {
    long countByPostID(Integer postID);
    boolean existsByUserIDAndPostID(Integer userID, Integer postID);
    Optional<Likes> findByUserIDAndPostID(Integer userID, Integer postID);
}
