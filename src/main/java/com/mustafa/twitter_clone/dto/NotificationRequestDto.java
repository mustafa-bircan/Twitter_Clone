package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class NotificationRequestDto {
    private Long receiverId;
    private Long senderId;
    private String type;
    private Long tweetId;
    private String content;
}
