package com.ssglobal.revalida.jibe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String firstname;
    private String lastname;
    private String bio;
    private String username;
    private String email;
    private String imageUrl;
    private Boolean firstTimeLogin;

    private Integer postsCount;

    private Integer followersCount;
    private Integer followingCount;
}
