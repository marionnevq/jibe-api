package com.ssglobal.revalida.jibe.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "_likes")
public class Likes {

    @Id
    @GeneratedValue
    private Integer reactionID;

    private Integer userID;

    private Integer commentID;

    private Integer postID;

    private Integer likedComment;

    private Integer postLikes;

}
