package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Post;

import java.util.Collection;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {
    long countByUser(User user);
    long countByUser_Username(String username);
    List<Post> findByUser_IdInOrderByDatePostedDesc(Collection<Integer> ids);
    List<Post> findByUser_UsernameOrderByDatePostedDesc(String username);
    List<Post> findByPostIDNotNullOrderByDatePostedDesc();

}
