package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    long countByPost_PostID(Integer postID);
    List<Comment> findByPost_PostIDOrderByDateCommentedDesc(Integer postID);
    List<Comment> findByUser_Posts_PostIDOrderByDateCommentedAsc(Integer postID);

}
