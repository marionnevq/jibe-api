package com.ssglobal.revalida.jibe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikesDTO {
	
	private Integer reactionID;


    private Integer userID;


    private Integer commentID;


    private Integer postID;

    private Integer likedComment;


    private Integer postLikes;
}
