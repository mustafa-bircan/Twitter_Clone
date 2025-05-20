package com.mustafa.twitter_clone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDto {
    private Long id;
    private Long receiverId;
    private String receiverUsername;
    private Long senderId;
    private String senderUsername;
    private String type;
    private Long tweetId;
    private String content;
    private boolean isRead;
    private LocalDateTime createdAt;
}
