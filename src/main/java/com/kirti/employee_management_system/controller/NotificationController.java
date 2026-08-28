package com.kirti.employee_management_system.controller;

import com.kirti.employee_management_system.entity.Notification;
import com.kirti.employee_management_system.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications(Authentication auth) {
        return ResponseEntity.ok(notificationService.getForUser(auth.getName()));
    }

    @GetMapping("/unread-count")
    public ResponseEntity<Long> getUnreadCount(Authentication auth) {
        return ResponseEntity.ok(notificationService.countUnread(auth.getName()));
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/read-all")
    public ResponseEntity<Void> markAllAsRead(Authentication auth) {
        notificationService.markAllAsRead(auth.getName());
        return ResponseEntity.ok().build();
    }
}