package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.TweetRequestDto;
import com.mustafa.twitter_clone.dto.TweetResponseDto;
import com.mustafa.twitter_clone.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public TweetResponseDto createTweet(@RequestBody TweetRequestDto dto) {
        return tweetService.createTweet(dto);
    }

    @GetMapping("/{id}")
    public TweetResponseDto getTweetById(@PathVariable Long id) {
        return tweetService.getTweetById(id);
    }

    @GetMapping("/findByUserId")
    public List<TweetResponseDto> getTweetsByUserId(@RequestParam Long userId) {
        return tweetService.getTweetsByUserId(userId);
    }

    @GetMapping("/findByUsername")
    public List<TweetResponseDto> getTweetsByUsername(@RequestParam String username) {
        return tweetService.getTweetsByUsername(username);
    }

    @GetMapping
    public List<TweetResponseDto> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @PutMapping("/{id}")
    public TweetResponseDto updateTweet(@PathVariable Long id, @RequestBody TweetRequestDto dto) {
        return tweetService.updateTweet(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable Long id) {
        tweetService.deleteTweet(id);
    }
}
