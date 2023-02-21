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
	
	@Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String firstname;
    
    @NotNull
    @Size(max = 100)
    private String lastname;
    
    @NotNull
    @Size(max = 100)
    private String username;
    
    @NotNull
    @Size(max = 100)
    private String email;
    
    @NotNull
    @Size(max = 255)
    private String bio;
    
    @NotNull
    @Size(max = 100)
    private String password;

    @Size(max = 255)
    private String imageUrl;
    
    @NotNull
    private Boolean firstTimeLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer userLike;

    private Integer userFollow;
}
