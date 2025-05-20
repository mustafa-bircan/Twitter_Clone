package com.mustafa.twitter_clone.utils;

import com.mustafa.twitter_clone.dto.CommentResponseDto;
import com.mustafa.twitter_clone.dto.LikeResponseDto;
import com.mustafa.twitter_clone.dto.MediaResponseDto;
import com.mustafa.twitter_clone.dto.UserResponseDto;
import com.mustafa.twitter_clone.entity.Comment;
import com.mustafa.twitter_clone.entity.Like;
import com.mustafa.twitter_clone.entity.Media;
import com.mustafa.twitter_clone.entity.User;

public class DtoUtils {
    public static UserResponseDto convertUserToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static MediaResponseDto convertMediaToDto(Media media) {
        MediaResponseDto dto = new MediaResponseDto();
        dto.setId(media.getId());
        dto.setUserId(media.getUser().getId());
        dto.setUsername(media.getUser().getUsername());
        dto.setTweetId(media.getTweet().getId());
        dto.setMediaUrl(media.getMediaUrl());
        dto.setMediaType(media.getMediaType());
        return dto;
    }

    public static CommentResponseDto convertCommentToDto(Comment comment) {
        CommentResponseDto dto = new CommentResponseDto();
        dto.setId(comment.getId());
        dto.setUserId(comment.getUser().getId());
        dto.setUsername(comment.getUser().getUsername());
        dto.setTweetId(comment.getTweet().getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    public static LikeResponseDto convertLikeToDto(Like like) {
        LikeResponseDto dto = new LikeResponseDto();
        dto.setId(like.getId());
        dto.setUserId(like.getUser().getId());
        dto.setUsername(like.getUser().getUsername());
        dto.setTweetId(like.getTweet().getId());
        dto.setCreatedAt(like.getCreatedAt());
        return dto;
    }
}
