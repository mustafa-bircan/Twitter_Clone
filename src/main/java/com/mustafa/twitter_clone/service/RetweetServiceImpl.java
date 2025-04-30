package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.RetweetRequestDto;
import com.mustafa.twitter_clone.dto.RetweetResponseDto;
import com.mustafa.twitter_clone.entity.Retweet;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.RetweetRepository;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetweetServiceImpl implements RetweetService{

    @Autowired
    private RetweetRepository retweetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    public RetweetServiceImpl(RetweetRepository retweetRepository, UserRepository userRepository, TweetRepository tweetRepository) {
        this.retweetRepository = retweetRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    private RetweetResponseDto convertToDto(Retweet retweet) {
        RetweetResponseDto dto = new RetweetResponseDto();
        dto.setId(retweet.getId());
        dto.setUserId(retweet.getUser().getId());
        dto.setUsername(retweet.getUser().getUsername());
        dto.setTweetId(retweet.getTweet().getId());
        dto.setTweetContent(retweet.getTweet().getContent());
        dto.setCreatedAt(retweet.getCreatedAt());
        return dto;
    }

    @Override
    public RetweetResponseDto createRetweet(RetweetRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = tweetRepository.findById(dto.getTweetId())
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        Retweet retweet = new Retweet();
        retweet.setUser(user);
        retweet.setTweet(tweet);
        retweet.setCreatedAt(LocalDateTime.now());

        Retweet saved = retweetRepository.save(retweet);
        return convertToDto(saved);
    }

    @Override
    public List<RetweetResponseDto> getRetweetsByUserId(Long userId) {
        return retweetRepository.findByUserId(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RetweetResponseDto> getRetweetsByTweetId(Long tweetId) {
        return retweetRepository.findByTweetId(tweetId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RetweetResponseDto> getRetweetsByUserAndTweet(Long userId, Long tweetId) {
        return retweetRepository.findByUserIdAndTweetId(userId, tweetId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRetweet(Long id) {
        retweetRepository.deleteById(id);
    }
}
