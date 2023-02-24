package com.ssglobal.revalida.jibe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagReferenceDTO {


	private Integer tagID;

	private String tagValue;

}
