package com.ssglobal.revalida.jibe.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String bio;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
}
