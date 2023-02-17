package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssglobal.revalida.jibe.model.Likes;


public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
