package com.ssglobal.revalida.jibe.service;

import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.NotificationDTO;
import com.ssglobal.revalida.jibe.model.Notification;
import com.ssglobal.revalida.jibe.repository.NotificationRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

	private final ModelMapper modelMapper;
	private final NotificationRepository notificationRepository;
	private final UserRepository userRepository;

	public NotificationDTO createNotification(NotificationDTO request) {
		request.setUserID(request.getUserID());
		var user = modelMapper.map(request, Notification.class);
		var saved = notificationRepository.save(user);
		return modelMapper.map(saved, NotificationDTO.class);
	}

	public boolean deleteNotification(Integer id) {
		final Notification notification = notificationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		notificationRepository.delete(notification);
		return true;
	}

    public List<NotificationDTO> getNotifications(String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(NotFoundException::new);

		return notificationRepository.findByUserID(user.getId()).stream().map((notification -> {
			return modelMapper.map(notification,NotificationDTO.class);
		})).toList();
    }
}
