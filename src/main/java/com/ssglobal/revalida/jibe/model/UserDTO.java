package com.ssglobal.revalida.jibe.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements UserDetails{

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
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    
    public boolean firstTimeLogin() {
    	return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @NotNull
    private Boolean firstTimeLogin;

    private Integer userLike;

    private Integer userFollow;
}
