package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.UserResponseDto;
import com.mustafa.twitter_clone.entity.Role;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.RoleRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponseDto createUser(UserResponseDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        Role defaultRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found!"));

        user.getRoles().add(defaultRole);

        User saved = userRepository.save(user);
        return DtoUtils.convertUserToDto(saved);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(DtoUtils::convertUserToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return DtoUtils.convertUserToDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
