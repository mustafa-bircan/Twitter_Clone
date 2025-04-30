package com.mustafa.twitter_clone.controller;

import com.mustafa.twitter_clone.dto.CommentRequestDto;
import com.mustafa.twitter_clone.dto.CommentResponseDto;
import com.mustafa.twitter_clone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto dto) {
        return commentService.createComment(dto);
    }

    @GetMapping("/byUserId")
    public List<CommentResponseDto> getCommentsByUserId(@RequestParam Long userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @GetMapping("/byTweetId")
    public List<CommentResponseDto> getCommentsByTweetId(@RequestParam Long tweetId) {
        return commentService.getCommentsByTweetId(tweetId);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
