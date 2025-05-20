package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.NotificationRequestDto;
import com.mustafa.twitter_clone.dto.NotificationResponseDto;
import com.mustafa.twitter_clone.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public NotificationResponseDto createNotification(@RequestBody NotificationRequestDto dto) {
        return notificationService.createNotification(dto);
    }

    @GetMapping("/user/{userId}")
    public List<NotificationResponseDto> getNotifications(@PathVariable Long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    @PutMapping("/{id}/read")
    public void markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}
