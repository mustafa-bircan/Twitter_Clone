package com.mustafa.twitter_clone.service;

import com.mustafa.twitter_clone.dto.NotificationRequestDto;
import com.mustafa.twitter_clone.dto.NotificationResponseDto;
import com.mustafa.twitter_clone.entity.Notification;
import com.mustafa.twitter_clone.entity.Tweet;
import com.mustafa.twitter_clone.entity.User;
import com.mustafa.twitter_clone.repository.NotificationRepository;
import com.mustafa.twitter_clone.repository.TweetRepository;
import com.mustafa.twitter_clone.repository.UserRepository;
import com.mustafa.twitter_clone.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public NotificationResponseDto createNotification(NotificationRequestDto dto) {
        User sender = userRepository.findById(dto.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(dto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Tweet tweet = null;
        if (dto.getTweetId() != null) {
            tweet = tweetRepository.findById(dto.getTweetId())
                    .orElseThrow(() -> new RuntimeException("Tweet not found"));
        }

        Notification notification = new Notification();
        notification.setSender(sender);
        notification.setReceiver(receiver);
        notification.setType(dto.getType());
        notification.setTweet(tweet);
        notification.setContent(dto.getContent());
        notification.setRead(false);

        Notification saved = notificationRepository.save(notification);
        return DtoUtils.convertNotificationToDto(saved);
    }

    @Override
    public List<NotificationResponseDto> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByReceiverId(userId).stream()
                .map(DtoUtils::convertNotificationToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
