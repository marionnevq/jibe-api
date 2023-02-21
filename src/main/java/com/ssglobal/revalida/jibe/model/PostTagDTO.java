package com.ssglobal.revalida.jibe.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTagDTO {

	private Integer postID;

	@NotNull
	private Integer tagID;

	private Integer postTags;

	private List<Integer> postRefs;

}
