package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.RetweetRequestDto;
import com.mustafa.twitter_clone.dto.RetweetResponseDto;
import com.mustafa.twitter_clone.entity.Retweet;

import java.util.List;

public interface RetweetService {
    RetweetResponseDto createRetweet(RetweetRequestDto dto);
    List<RetweetResponseDto> getRetweetsByUserId(Long userId);
    List<RetweetResponseDto> getRetweetsByTweetId(Long tweetId);
    List<RetweetResponseDto> getRetweetsByUserAndTweet(Long userId, Long tweetId);
    void deleteRetweet(Long id);
}
