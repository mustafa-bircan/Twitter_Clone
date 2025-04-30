package com.mustafa.twitter_clone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDto {
    private Long id;
    private Long userId;
    private String username;
    private Long tweetId;
    private String content;
    private LocalDateTime createdAt;
}
