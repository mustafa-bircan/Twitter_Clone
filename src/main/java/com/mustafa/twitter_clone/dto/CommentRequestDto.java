package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class CommentRequestDto {
    private Long userId;
    private Long tweetId;
    private String content;
}
