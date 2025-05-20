package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.LikeRequestDto;
import com.mustafa.twitter_clone.dto.LikeResponseDto;
import com.mustafa.twitter_clone.entity.Like;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.LikeRepository;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public LikeResponseDto likeTweet(LikeRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = tweetRepository.findById(dto.getTweetId())
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        Like like = new Like();
        like.setUser(user);
        like.setTweet(tweet);

        Like saved = likeRepository.save(like);
        return DtoUtils.convertLikeToDto(saved);
    }

    @Override
    public void unlike(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public List<LikeResponseDto> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId)
                .stream()
                .map(DtoUtils::convertLikeToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeResponseDto> getLikesByTweetId(Long tweetId) {
        return likeRepository.findByTweetId(tweetId)
                .stream()
                .map(DtoUtils::convertLikeToDto)
                .collect(Collectors.toList());
    }
}
