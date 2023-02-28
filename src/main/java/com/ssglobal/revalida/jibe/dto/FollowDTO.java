package com.ssglobal.revalida.jibe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {

	private Integer followID;

    private Integer followerID;

    private String followeeUsername;
}
