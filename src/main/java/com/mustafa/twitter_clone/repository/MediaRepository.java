package com.mustafa.twitter_clone.repository;

import com.mustafa.twitter_clone.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByUserId(Long userId);

    List<Media> findByTweetId(Long tweetId);
}
