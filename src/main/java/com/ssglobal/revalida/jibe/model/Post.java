package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = jakarta.persistence.CascadeType.REMOVE)
    private Set<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = jakarta.persistence.CascadeType.REMOVE, orphanRemoval = true)
    private Set<PostTag> postTags;


}
