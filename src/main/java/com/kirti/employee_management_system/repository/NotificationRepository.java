package com.kirti.employee_management_system.repository;

import com.kirti.employee_management_system.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByRecipientUsernameOrderByCreatedAtDesc(String username);

    long countByRecipientUsernameAndIsReadFalse(String username);
}