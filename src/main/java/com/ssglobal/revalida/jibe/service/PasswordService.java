package com.ssglobal.revalida.jibe.service;

import com.ssglobal.revalida.jibe.dto.RequestPasswordDTO;
import com.ssglobal.revalida.jibe.model.PasswordToken;
import com.ssglobal.revalida.jibe.repository.PasswordTokenRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.util.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordTokenRepository passwordTokenRepository;
    public String getResetToken(RequestPasswordDTO request) {

        var user = userRepository.findByEmail(request.getEmail());

        if(user.isEmpty()) {
            throw new NotFoundException();
        }

        var existingToken = passwordTokenRepository.existsByEmail(request.getEmail());

        if(existingToken) {
            throw new RuntimeException("existing password reset");
        }

        String token = jwtService.generateResetPasswordToken(user.get());
        PasswordToken tokenEntity = PasswordToken.builder()
                .email(user.get().getEmail())
                .token(token)
                .build();

        passwordTokenRepository.save(tokenEntity);
        return token;
    }
}
