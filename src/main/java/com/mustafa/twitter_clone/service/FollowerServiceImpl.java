package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.FollowerRequestDto;
import com.mustafa.twitter_clone.dto.FollowerResponseDto;
import com.mustafa.twitter_clone.entity.Follower;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.FollowerRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private  FollowerRepository followerRepository;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  DtoUtils dtoUtils;

    @Override
    public FollowerResponseDto follow(FollowerRequestDto requestDto) {
        if (followerRepository.existsByFollowerIdAndFollowingId(requestDto.getFollowerId(), requestDto.getFollowingId())) {
            throw new RuntimeException("You already follow this user.");
        }

        User follower = userRepository.findById(requestDto.getFollowerId())
                .orElseThrow(() -> new RuntimeException("Follower user not found"));
        User following = userRepository.findById(requestDto.getFollowingId())
                .orElseThrow(() -> new RuntimeException("Following user not found"));

        Follower entity = new Follower();
        entity.setFollower(follower);
        entity.setFollowing(following);

        Follower saved = followerRepository.save(entity);
        return dtoUtils.convertFollowerToDto(saved);
    }

    @Override
    public void unfollow(Long followerId, Long followingId) {
        Follower entity = followerRepository.findByFollowerId(followerId).stream()
                .filter(f -> f.getFollowing().getId().equals(followingId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Follow relationship not found"));

        followerRepository.delete(entity);
    }

    @Override
    public List<FollowerResponseDto> getFollowers(Long userId) {
        return followerRepository.findByFollowingId(userId).stream()
                .map(dtoUtils::convertFollowerToDto)
                .toList();
    }

    @Override
    public List<FollowerResponseDto> getFollowings(Long userId) {
        return followerRepository.findByFollowerId(userId).stream()
                .map(dtoUtils::convertFollowerToDto)
                .toList();
    }
}