package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;

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
@Table(name = "_post")
public class Post {

    @Id
    @GeneratedValue
    private Integer postID;

    private String body;

    private Integer userID;

    private LocalDate datePosted;

    private Integer postComments;

}
