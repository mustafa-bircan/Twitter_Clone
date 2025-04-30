package com.mustafa.twitter_clone.utils;

import com.mustafa.twitter_clone.dto.MediaResponseDto;
import com.mustafa.twitter_clone.dto.UserResponseDto;
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
}
