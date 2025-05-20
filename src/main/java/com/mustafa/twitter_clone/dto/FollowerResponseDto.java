package com.mustafa.twitter_clone.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FollowerResponseDto {
    private Long id;
    private Long followerId;
    private String followerUsername;
    private Long followingId;
    private String followingUsername;
    private LocalDateTime createdAt;
}
