package com.ssglobal.revalida.jibe.service;

import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.domain.Notification;
import com.ssglobal.revalida.jibe.model.NotificationDTO;
import com.ssglobal.revalida.jibe.repository.NotificationRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;

    public NotificationService(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    
	public boolean create(final NotificationDTO notificationDTO, final Integer userID, 
			final Integer commentID, final Integer postID) {
		final Notification notification = new Notification();
		mapToEntity(notificationDTO, notification);
		boolean isSuccess = notificationRepository.save(notification) != null;
		return isSuccess;
	}
	
	 public void update(final Integer id, final NotificationDTO notificationDTO) {
	        final Notification notification = notificationRepository.findById(id)
	                .orElseThrow(NotFoundException::new);
	        mapToEntity(notificationDTO, notification);
	        notificationRepository.save(notification);
	    }
    
    private Notification mapToEntity(final NotificationDTO notificationDTO,
            final Notification notification) {
        notification.setUserID(notificationDTO.getUserID());
        notification.setField(notificationDTO.getField());
        return notification;
    }
}
