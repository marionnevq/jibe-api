package com.ssglobal.revalida.jibe.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowDTO {

	private Integer followID;

    @NotNull
    private Integer followerID;

    @NotNull
    private Integer followeeID;
}
