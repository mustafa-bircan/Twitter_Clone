package com.mustafa.twitter_clone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tweets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private Set<Like> likes;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private Set<Retweet> retweets;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private Set<Media> media;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (this.updatedAt == null) {
            this.updatedAt = LocalDateTime.now();
        }
    }
}
