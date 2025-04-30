package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.CommentRequestDto;
import com.mustafa.twitter_clone.dto.CommentResponseDto;
import com.mustafa.twitter_clone.entity.Comment;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.CommentRepository;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public CommentResponseDto createComment(CommentRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = tweetRepository.findById(dto.getTweetId())
                .orElseThrow(() -> new RuntimeException("Tweet not found"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setTweet(tweet);
        comment.setContent(dto.getContent());

        Comment saved = commentRepository.save(comment);
        return DtoUtils.convertCommentToDto(saved);
    }

    @Override
    public List<CommentResponseDto> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId)
                .stream()
                .map(DtoUtils::convertCommentToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponseDto> getCommentsByTweetId(Long tweetId) {
        return commentRepository.findByTweetId(tweetId)
                .stream()
                .map(DtoUtils::convertCommentToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}