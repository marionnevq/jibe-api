package com.ssglobal.revalida.jibe.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

	private Integer postID;


	private String body;


	private Integer userID;


	private String userUsername;
	private String userFirstname;
	private String userLastname;


	private LocalDate datePosted;

	private String imageUrl;

}
