package com.ssglobal.revalida.jibe.dto;

import com.ssglobal.revalida.jibe.model.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private static final long serialVersionUID = 1L;
	

    private Integer id;


    private String firstname;
    

    private String lastname;
    

    private String username;
    

    private String email;
    

    private String bio;
    

    private String password;


    private String imageUrl;

    private Boolean firstTimeLogin;

//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    private Integer userLike;
//
//    private Integer userFollow;
}
