package com.ssglobal.revalida.jibe.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

	private Integer commentID;

	@NotNull
	private String value;

	private String media;

	@NotNull
	private Integer userID;

	@NotNull
	private Integer postID;

	@NotNull
	private LocalDate dateCommented;



}
