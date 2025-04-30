package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.UserResponseDto;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserResponseDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        User saved = userRepository.save(user);

        UserResponseDto response = new UserResponseDto();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        return response;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserResponseDto dto = new UserResponseDto();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
