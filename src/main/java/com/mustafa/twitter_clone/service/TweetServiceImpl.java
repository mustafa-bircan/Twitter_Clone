package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.TweetRequestDto;
import com.mustafa.twitter_clone.dto.TweetResponseDto;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService{

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public TweetServiceImpl(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    private TweetResponseDto convertToDto(Tweet tweet) {
        TweetResponseDto dto = new TweetResponseDto();
        dto.setId(tweet.getId());
        dto.setContent(tweet.getContent());
        dto.setCreatedAt(tweet.getCreatedAt());
        dto.setUpdatedAt(tweet.getUpdatedAt());
        dto.setUserId(tweet.getUser().getId());
        dto.setUsername(tweet.getUser().getUsername());
        return dto;
    }

    @Override
    public TweetResponseDto createTweet(TweetRequestDto tweetRequestDto) {
        User user = userRepository.findById(tweetRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = new Tweet();
        tweet.setContent(tweetRequestDto.getContent());
        tweet.setUser(user);
        tweet.setCreatedAt(LocalDateTime.now());
        tweet.setUpdatedAt(LocalDateTime.now());

        Tweet savedTweet = tweetRepository.save(tweet);

        return convertToDto(savedTweet);
    }

    @Override
    public TweetResponseDto getTweetById(Long id) {
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));
        return convertToDto(tweet);
    }

    @Override
    public List<TweetResponseDto> getAllTweets() {
        return tweetRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TweetResponseDto updateTweet(Long id, TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));
        tweet.setContent(tweetRequestDto.getContent());
        tweet.setUpdatedAt(LocalDateTime.now());

        Tweet updatedTweet = tweetRepository.save(tweet);

        return convertToDto(updatedTweet);
    }

    @Override
    public List<TweetResponseDto> getTweetsByUsername(String username) {
        List<Tweet> tweets = tweetRepository.findByUserUsername(username);
        return tweets.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TweetResponseDto> getTweetsByUserId(Long userId) {
        List<Tweet> tweets = tweetRepository.findByUserId(userId);
        return tweets.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTweet(Long id) {
        tweetRepository.deleteById(id);
    }
}
