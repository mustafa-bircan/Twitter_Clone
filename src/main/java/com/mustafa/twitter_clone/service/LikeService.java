package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.LikeRequestDto;
import com.mustafa.twitter_clone.dto.LikeResponseDto;

import java.util.List;

public interface LikeService {
    LikeResponseDto likeTweet(LikeRequestDto dto);
    void unlike(Long id);
    List<LikeResponseDto> getLikesByUserId(Long userId);
    List<LikeResponseDto> getLikesByTweetId(Long tweetId);
}
