package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.FollowerRequestDto;
import com.mustafa.twitter_clone.dto.FollowerResponseDto;

import java.util.List;

public interface FollowerService {
    FollowerResponseDto follow(FollowerRequestDto requestDto);
    void unfollow(Long followerId, Long followingId);
    List<FollowerResponseDto> getFollowers(Long userId);
    List<FollowerResponseDto> getFollowings(Long userId);
}
