package com.ssglobal.revalida.jibe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowDTO {

	private Integer followID;

    private Integer followerID;

    private Integer followeeID;
}
