package com.mustafa.twitter_clone.dto;

import lombok.Data;

@Data
public class FollowerRequestDto {
    private Long followerId;
    private Long followingId;
}
