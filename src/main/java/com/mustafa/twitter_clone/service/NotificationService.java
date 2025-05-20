package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.NotificationRequestDto;
import com.mustafa.twitter_clone.dto.NotificationResponseDto;

import java.util.List;

public interface NotificationService {
    NotificationResponseDto createNotification(NotificationRequestDto dto);
    List<NotificationResponseDto> getNotificationsByUserId(Long userId);
    void markAsRead(Long notificationId);
    void deleteNotification(Long notificationId);
}
