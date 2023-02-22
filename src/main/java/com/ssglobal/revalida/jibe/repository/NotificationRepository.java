package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.Notification;


public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
