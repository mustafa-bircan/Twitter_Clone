package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.MediaRequestDto;
import com.mustafa.twitter_clone.dto.MediaResponseDto;
import com.mustafa.twitter_clone.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @PostMapping
    public MediaResponseDto createMedia(@RequestBody MediaRequestDto dto) {
        return mediaService.createMedia(dto);
    }

    @GetMapping("/byUserId")
    public List<MediaResponseDto> getMediaByUserId(@RequestParam Long userId) {
        return mediaService.getMediaByUserId(userId);
    }

    @GetMapping("/byTweetId")
    public List<MediaResponseDto> getMediaByTweetId(@RequestParam Long tweetId) {
        return mediaService.getMediaByTweetId(tweetId);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }
}
