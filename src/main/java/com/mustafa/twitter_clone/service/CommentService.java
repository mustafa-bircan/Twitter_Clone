package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.CommentRequestDto;
import com.mustafa.twitter_clone.dto.CommentResponseDto;

import java.util.List;

public interface CommentService {
    CommentResponseDto createComment(CommentRequestDto dto);
    List<CommentResponseDto> getCommentsByUserId(Long userId);
    List<CommentResponseDto> getCommentsByTweetId(Long tweetId);
    void deleteComment(Long id);
}
