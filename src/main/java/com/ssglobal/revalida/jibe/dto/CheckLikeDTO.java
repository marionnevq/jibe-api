package com.ssglobal.revalida.jibe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckLikeDTO {

    private Integer userId;

    private Integer postId;
}
