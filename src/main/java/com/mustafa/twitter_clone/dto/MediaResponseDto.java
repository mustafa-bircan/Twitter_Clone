package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class MediaResponseDto {
    private Long id;
    private Long userId;
    private String username;
    private Long tweetId;
    private String mediaUrl;
    private String mediaType;
}
