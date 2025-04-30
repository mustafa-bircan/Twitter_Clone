package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class RetweetRequestDto {
    private Long userId;
    private Long tweetId;
}