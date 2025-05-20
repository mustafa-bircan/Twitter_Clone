package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.LikeRequestDto;
import com.mustafa.twitter_clone.dto.LikeResponseDto;
import com.mustafa.twitter_clone.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public LikeResponseDto likeTweet(@RequestBody LikeRequestDto dto) {
        return likeService.likeTweet(dto);
    }

    @DeleteMapping("/{id}")
    public void unlike(@PathVariable Long id) {
        likeService.unlike(id);
    }

    @GetMapping("/user/{userId}")
    public List<LikeResponseDto> getLikesByUser(@PathVariable Long userId) {
        return likeService.getLikesByUserId(userId);
    }

    @GetMapping("/tweet/{tweetId}")
    public List<LikeResponseDto> getLikesByTweet(@PathVariable Long tweetId) {
        return likeService.getLikesByTweetId(tweetId);
    }
}
