package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.domain.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {
}
