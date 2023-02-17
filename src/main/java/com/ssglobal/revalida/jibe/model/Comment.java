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
@Table(name = "_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Integer commentID;
    private String value;
    private Integer userID;
    private Integer postID;
    private LocalDate dateCommented;
    
    

}
