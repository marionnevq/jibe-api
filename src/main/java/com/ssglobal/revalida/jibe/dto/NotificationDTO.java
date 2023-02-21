package com.ssglobal.revalida.jibe.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {

	private Integer id;

    @NotNull
    private Integer userID;

    @NotNull
    @Size(max = 255)
    private String field;

}
