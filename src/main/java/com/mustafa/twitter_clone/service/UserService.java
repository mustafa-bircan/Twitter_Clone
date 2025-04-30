package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserResponseDto userResponseDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    void deleteUser(Long id);
}
