package com.mustafa.twitter_clone.utils;

import com.mustafa.twitter_clone.dto.UserResponseDto;
import com.mustafa.twitter_clone.entity.User;

public class DtoUtils {
    public static UserResponseDto convertUserToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
