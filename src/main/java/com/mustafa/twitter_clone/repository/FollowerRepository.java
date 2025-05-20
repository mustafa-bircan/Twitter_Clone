package com.mustafa.twitter_clone.repository;

import com.mustafa.twitter_clone.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
    List<Follower> findByFollowerId(Long followerId);
    List<Follower> findByFollowingId(Long followingId);
    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);
}
