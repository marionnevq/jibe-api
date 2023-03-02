package com.ssglobal.revalida.jibe.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String firstname;
    private String lastname;
    private String bio;
    private String username;
    private String birthday;
    private String email;
    private String password;
    private String imageUrl;
}
