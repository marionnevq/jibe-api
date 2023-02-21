package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_post")
public class Post {

    @Id
    @GeneratedValue
    private Integer postID;

    @Column(nullable = false)
    private String body;

    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDate datePosted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_comments_id", nullable = false)
//    private Comment postComments;
//
//    @OneToMany(mappedBy = "postLikes")
//    private Set<Likes> postLikesLikes;
//
//    @OneToMany(mappedBy = "postTags")
//    private Set<PostTag> postTagsPostTags;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_post_id")
//    private User userPost;

}
