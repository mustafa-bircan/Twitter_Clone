package com.mustafa.twitter_clone.utils;

import com.mustafa.twitter_clone.dto.*;
import com.mustafa.twitter_clone.entity.*;

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

    public static NotificationResponseDto convertNotificationToDto(Notification notification) {
        NotificationResponseDto dto = new NotificationResponseDto();
        dto.setId(notification.getId());
        dto.setReceiverId(notification.getReceiver().getId());
        dto.setReceiverUsername(notification.getReceiver().getUsername());
        dto.setSenderId(notification.getSender().getId());
        dto.setSenderUsername(notification.getSender().getUsername());
        dto.setType(notification.getType());
        dto.setTweetId(notification.getTweet() != null ? notification.getTweet().getId() : null);
        dto.setContent(notification.getContent());
        dto.setRead(notification.isRead());
        dto.setCreatedAt(notification.getCreatedAt());
        return dto;
    }

    public FollowerResponseDto convertFollowerToDto(Follower follower) {
        FollowerResponseDto dto = new FollowerResponseDto();
        dto.setId(follower.getId());
        dto.setFollowerId(follower.getFollower().getId());
        dto.setFollowerUsername(follower.getFollower().getUsername());
        dto.setFollowingId(follower.getFollowing().getId());
        dto.setFollowingUsername(follower.getFollowing().getUsername());
        dto.setCreatedAt(follower.getCreatedAt());
        return dto;
    }
}
