package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

	private Integer postID;

	@NotNull
	private String body;

	private String imageUrl;
	
	@NotNull
	private Integer userID;

	@NotNull
	private LocalDate datePosted;

	@NotNull
	private Integer postComments;

	private Integer userPost;
}
