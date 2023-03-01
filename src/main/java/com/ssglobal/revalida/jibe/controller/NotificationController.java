package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssglobal.revalida.jibe.dto.NotificationDTO;
import com.ssglobal.revalida.jibe.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;
	private final JwtService jwtService;

	@PostMapping("/notification")
    public ResponseEntity<NotificationDTO> addNotification(@RequestBody NotificationDTO request) {
        return ResponseEntity.ok().body(notificationService.createNotification(request));
    }

	@PutMapping("/notification/{id}")
	public ResponseEntity<Void> updateNotification(@PathVariable final Integer id){
		notificationService.deleteNotification(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/notification/me")
	public ResponseEntity<List<NotificationDTO>> getNotifications(@RequestHeader(name = "Authorization") String token) {
		final String jwt = token.substring(7);
		final String userEmail = jwtService.extractUsername(jwt);
		return ResponseEntity.ok().body(notificationService.getNotifications(userEmail));
	}

	@DeleteMapping("/notification/{id}")
	public ResponseEntity<Boolean> deleteNotification(@PathVariable Integer id) {
		return ResponseEntity.ok().body(notificationService.deleteNotification(id));
	}

}
