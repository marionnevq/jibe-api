package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

	private Integer commentID;

	@NotNull
	private String value;

	@NotNull
	private Integer userID;

	@NotNull
	private Integer postID;

	@NotNull
	private LocalDate dateCommented;

	private Integer userComment;

}
