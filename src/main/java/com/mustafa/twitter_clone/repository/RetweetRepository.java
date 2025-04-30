package com.mustafa.twitter_clone.repository;

import com.mustafa.twitter_clone.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetweetRepository extends JpaRepository<Retweet, Long> {
    List<Retweet> findByUserId(Long userId);
    List<Retweet> findByTweetId(Long tweetId);

    @Query("SELECT r FROM Retweet r WHERE r.user.id = :userId AND r.tweet.id = :tweetId")
    List<Retweet> findByUserIdAndTweetId(Long userId, Long tweetId);
}
