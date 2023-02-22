package com.ssglobal.revalida.jibe.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagReferenceDTO {


	private Integer tagID;

	private String tagValue;

}
