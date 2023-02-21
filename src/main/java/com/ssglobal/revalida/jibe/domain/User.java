package com.ssglobal.revalida.jibe.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "_user")
public class User {

	@Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false, length = 255)
    private String bio;


    @Column(nullable = false, length = 100)
    private String password;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private Boolean firstTimeLogin;
    
    @OneToMany(mappedBy = "userPost")
    private Set<Post> userPostPosts;

    @OneToOne
    @JoinColumn(name = "user_like_id")
    private Likes userLike;

    @OneToMany(mappedBy = "userComment")
    private Set<Comment> userCommentComments;

    @OneToOne
    @JoinColumn(name = "user_follow_id")
    private Follow userFollow;
}
