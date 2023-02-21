package com.ssglobal.revalida.jibe.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagReferenceDTO {

	@Id
	@GeneratedValue
	private Integer tagID;

	@Column(nullable = false)
	private String tagValue;

	@Column(nullable = false)
	private String field;
}
