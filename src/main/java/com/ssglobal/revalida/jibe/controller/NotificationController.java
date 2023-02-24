package com.ssglobal.revalida.jibe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssglobal.revalida.jibe.dto.NotificationDTO;
import com.ssglobal.revalida.jibe.service.NotificationService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NotificationController {
	
	private final NotificationService notificationService;
	
	@PostMapping("/notification")
    public ResponseEntity<NotificationDTO> addNotification(@RequestBody NotificationDTO request) {
        return ResponseEntity.ok().body(notificationService.createNotification(request));
    }
	
	@DeleteMapping("/notification/{id}")
	public ResponseEntity<Void> updateNotification(@PathVariable final Integer id){
		notificationService.deleteNotification(id);
		return ResponseEntity.noContent().build();
	}
	
}
