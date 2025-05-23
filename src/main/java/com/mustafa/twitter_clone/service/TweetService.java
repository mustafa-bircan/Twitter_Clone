package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.TweetRequestDto;
import com.mustafa.twitter_clone.dto.TweetResponseDto;

import java.util.List;

public interface TweetService {
    TweetResponseDto createTweet(TweetRequestDto tweetRequestDto);
    TweetResponseDto getTweetById(Long id);
    List<TweetResponseDto> getAllTweets();
    TweetResponseDto updateTweet(Long id, TweetRequestDto tweetRequestDto);
    List<TweetResponseDto> getTweetsByUsername(String username);
    List<TweetResponseDto> getTweetsByUserId(Long userId);
    void deleteTweet(Long id);
}
