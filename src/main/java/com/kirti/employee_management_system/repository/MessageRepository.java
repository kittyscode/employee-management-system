package com.kirti.employee_management_system.repository;

import com.kirti.employee_management_system.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRecipientUsernameOrderBySentAtDesc(String username);

    long countByRecipientUsernameAndIsReadFalse(String username);
}