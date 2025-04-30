package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.MediaRequestDto;
import com.mustafa.twitter_clone.dto.MediaResponseDto;

import java.util.List;

public interface MediaService {
    MediaResponseDto createMedia(MediaRequestDto dto);
    List<MediaResponseDto> getMediaByUserId(Long userId);
    List<MediaResponseDto> getMediaByTweetId(Long tweetId);
    void deleteMedia(Long id);
}