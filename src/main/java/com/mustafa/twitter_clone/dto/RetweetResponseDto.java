package com.mustafa.twitter_clone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RetweetResponseDto {
    private Long id;
    private Long userId;
    private String username;
    private Long tweetId;
    private String tweetContent;
    private LocalDateTime createdAt;
}