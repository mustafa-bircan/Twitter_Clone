package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class TweetRequestDto {
    private String content;
    private Long userId;
}
