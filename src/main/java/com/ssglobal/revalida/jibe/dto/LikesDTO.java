package com.ssglobal.revalida.jibe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikesDTO {
	
	private Integer reactionID;

    @NotNull
    private Integer userID;

    @NotNull
    private Integer commentID;

    @NotNull
    private Integer postID;

    private Integer likedComment;

    @NotNull
    private Integer postLikes;
}
