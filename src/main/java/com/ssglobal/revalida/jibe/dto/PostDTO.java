package com.ssglobal.revalida.jibe.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

	private Integer postID;

	@NotNull
	private String body;

	@NotNull
	private Integer userID;

	@NotNull
	private String userUsername;

	@NotNull
	private LocalDate datePosted;

	private String imageUrl;
//	@NotNull
//	private Integer postComments;
//
//	private Integer userPost;
}
