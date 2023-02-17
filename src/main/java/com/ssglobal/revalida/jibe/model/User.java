package com.ssglobal.revalida.jibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails
{

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;

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
    
    @OneToMany(mappedBy = "userPost")
    private Set<Post> userPostPosts;

    @OneToOne
    @JoinColumn(name = "user_like_id")
    private Likes userLike;

    @OneToMany(mappedBy = "userComment")
    private Set<Comment> userCommentComments;

    @OneToOne
    @JoinColumn(name = "user_follow_id")
    private Follow userFollow;
}
