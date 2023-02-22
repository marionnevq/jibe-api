package com.ssglobal.revalida.jibe.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostTagDTO {

	private Integer postPostID;


	private String tagValue;

}
