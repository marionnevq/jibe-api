package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Notification;

import java.util.List;


public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserID(Integer userID);
}
