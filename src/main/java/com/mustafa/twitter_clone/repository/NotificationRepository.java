package com.mustafa.twitter_clone.repository;

import com.mustafa.twitter_clone.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReceiverId(Long userId);
}
