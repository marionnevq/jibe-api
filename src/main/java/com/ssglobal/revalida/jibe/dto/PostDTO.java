package com.ssglobal.revalida.jibe.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class PostDTO {

	private Integer postID;

	@NotNull
	private String body;

	@NotNull
	private Integer userID;

	@NotNull
	private String username;

	@NotNull
	private LocalDate datePosted;

	private String imageUrl;
//	@NotNull
//	private Integer postComments;
//
//	private Integer userPost;
}
