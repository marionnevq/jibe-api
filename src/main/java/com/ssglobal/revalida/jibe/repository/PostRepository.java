package com.ssglobal.revalida.jibe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.domain.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {
	 Optional<Post> findByPostID(Integer postID);
	 List<Post> findPostsByUserID(Integer userID);
	 void deleteById(Integer postID);
}
