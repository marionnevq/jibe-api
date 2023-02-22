package com.ssglobal.revalida.jibe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.domain.Comment;
import com.ssglobal.revalida.jibe.domain.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
