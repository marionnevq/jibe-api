package com.ssglobal.revalida.jibe.model;

import java.util.List;

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
@Table(name = "_postTags")
public class PostTag {


    @Id
    @GeneratedValue
    private Integer postID;

    private Integer tagID;

    private Integer postTags;

    private List<Integer> postRefs;

}
