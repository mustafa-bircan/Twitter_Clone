package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.MediaRequestDto;
import com.mustafa.twitter_clone.dto.MediaResponseDto;
import com.mustafa.twitter_clone.entity.Media;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.MediaRepository;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    public MediaServiceImpl(MediaRepository mediaRepository, UserRepository userRepository, TweetRepository tweetRepository) {
        this.mediaRepository = mediaRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public MediaResponseDto createMedia(MediaRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = tweetRepository.findById(dto.getTweetId())
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        Media media = new Media();
        media.setUser(user);
        media.setTweet(tweet);
        media.setMediaUrl(dto.getMediaUrl());
        media.setMediaType(dto.getMediaType());

        Media savedMedia = mediaRepository.save(media);
        return DtoUtils.convertMediaToDto(savedMedia);
    }

    @Override
    public List<MediaResponseDto> getMediaByUserId(Long userId) {
        return mediaRepository.findByUserId(userId)
                .stream()
                .map(DtoUtils::convertMediaToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MediaResponseDto> getMediaByTweetId(Long tweetId) {
        return mediaRepository.findByTweetId(tweetId)
                .stream()
                .map(DtoUtils::convertMediaToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}