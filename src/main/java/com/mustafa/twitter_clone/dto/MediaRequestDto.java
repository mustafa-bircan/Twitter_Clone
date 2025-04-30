package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class MediaRequestDto {
    private Long userId;
    private Long tweetId;
    private String mediaUrl;
    private String mediaType;
}