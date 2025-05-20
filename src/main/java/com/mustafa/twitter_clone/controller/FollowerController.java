package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.FollowerRequestDto;
import com.mustafa.twitter_clone.dto.FollowerResponseDto;
import com.mustafa.twitter_clone.service.FollowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followers")
public class FollowerController {

    private FollowerService followerService;

    @PostMapping("/follow")
    public ResponseEntity<FollowerResponseDto> follow(@RequestBody FollowerRequestDto requestDto) {
        return ResponseEntity.ok(followerService.follow(requestDto));
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<Void> unfollow(@RequestParam Long followerId, @RequestParam Long followingId) {
        followerService.unfollow(followerId, followingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<FollowerResponseDto>> getFollowers(@PathVariable Long userId) {
        return ResponseEntity.ok(followerService.getFollowers(userId));
    }

    @GetMapping("/followings/{userId}")
    public ResponseEntity<List<FollowerResponseDto>> getFollowings(@PathVariable Long userId) {
        return ResponseEntity.ok(followerService.getFollowings(userId));
    }
}
