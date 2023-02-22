package com.ssglobal.revalida.jibe.dto;

import java.util.Collection;
import java.util.List;

import com.ssglobal.revalida.jibe.model.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer userLike;

    private Integer userFollow;
}
