package com.kirti.employee_management_system.service;

import com.kirti.employee_management_system.entity.Notification;
import com.kirti.employee_management_system.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getForUser(String username) {
        return notificationRepository.findByRecipientUsernameOrderByCreatedAtDesc(username);
    }

    public long countUnread(String username) {
        return notificationRepository.countByRecipientUsernameAndIsReadFalse(username);
    }

    public void markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    public void markAllAsRead(String username) {
        List<Notification> notifications =
                notificationRepository.findByRecipientUsernameOrderByCreatedAtDesc(username);
        notifications.forEach(n -> n.setRead(true));
        notificationRepository.saveAll(notifications);
    }
}