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


	private String body;


	private Integer userID;


	private String userUsername;


	private LocalDate datePosted;

	private String imageUrl;

}
