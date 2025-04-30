package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.RetweetRequestDto;
import com.mustafa.twitter_clone.dto.RetweetResponseDto;
import com.mustafa.twitter_clone.service.RetweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/retweets")
public class RetweetController {

    @Autowired
    private RetweetService retweetService;

    @PostMapping
    public RetweetResponseDto createRetweet(@RequestBody RetweetRequestDto dto) {
        return retweetService.createRetweet(dto);
    }

    @GetMapping("/byUserId")
    public List<RetweetResponseDto> getRetweetsByUserId(@RequestParam Long userId) {
        return retweetService.getRetweetsByUserId(userId);
    }

    @GetMapping("/byTweetId")
    public List<RetweetResponseDto> getRetweetsByTweetId(@RequestParam Long tweetId) {
        return retweetService.getRetweetsByTweetId(tweetId);
    }

    @GetMapping("/byUserAndTweet")
    public List<RetweetResponseDto> getRetweetsByUserAndTweet(@RequestParam Long userId, @RequestParam Long tweetId) {
        return retweetService.getRetweetsByUserAndTweet(userId, tweetId);
    }

    @DeleteMapping("/{id}")
    public void deleteRetweet(@PathVariable Long id) {
        retweetService.deleteRetweet(id);
    }
}
