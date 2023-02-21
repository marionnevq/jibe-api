package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
