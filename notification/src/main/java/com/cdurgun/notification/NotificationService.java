package com.cdurgun.notification;

import com.cdurgun.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                        .toCustomerId(request.toCustomerId())
                        .toCustomerEmail(request.toCustomerEmail())
                        .sender("cdurgun")
                        .message(request.message())
                        .sentAt(LocalDateTime.now())
                        .build();
        notificationRepository.save(notification);

    }
}
