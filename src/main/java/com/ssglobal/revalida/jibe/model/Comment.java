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
@Table(name = "_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Integer commentID;
    
    @Column(nullable = false)
    private String value;
    
    @Column(nullable = false)
    private Integer userID;
    
    @Column(nullable = false)
    private Integer postID;
    
    @Column(nullable = false)
    private LocalDate dateCommented;
    
    @OneToMany(mappedBy = "likedComment")
    private Set<Likes> likedCommentLikess;

    @OneToMany(mappedBy = "postComments")
    private Set<Post> postCommentsPosts;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_comment_id")
    private User userComment;
}
