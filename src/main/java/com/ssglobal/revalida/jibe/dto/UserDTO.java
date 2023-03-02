package com.ssglobal.revalida.jibe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Integer id;


    private String firstname;
    

    private String lastname;
    

    private String username;
    

    private String email;
    

    private String bio;

    private String birthday;


    @JsonIgnore
    private String password;


    private String imageUrl;

    private Boolean firstTimeLogin;

    private Integer postsCount;

    private Integer followersCount;
    private Integer followingCount;

//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    private Integer userLike;
//
//    private Integer userFollow;


}
