package com.ssglobal.revalida.jibe.service;


import com.ssglobal.revalida.jibe.dto.AuthenticationRequestDTO;

import com.ssglobal.revalida.jibe.dto.AuthenticationResponseDTO;

import com.ssglobal.revalida.jibe.dto.RegisterRequestDTO;
import com.ssglobal.revalida.jibe.model.Role;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseDTO register(RegisterRequestDTO request) throws EntityExistsException, Exception {

        if(userRepository.existsByUsername(request.getUsername())) {
            throw new EntityExistsException("username already taken");
        }

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new EntityExistsException("email already taken");
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .email(request.getEmail())
                .bio(request.getBio())
                .birthday(request.getBirthday())
                .imageUrl(request.getImageUrl())
                .firstTimeLogin(true)
                .role(Role.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) throws BadCredentialsException,Exception {
        System.out.println(request.getEmail());
        System.out.println(request.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =  userRepository.findByEmail(request.getEmail())
                .or(() -> { return(userRepository.findByUsername(request.getEmail()));})
                .orElseThrow(() -> {return new BadCredentialsException("Invalid Credentials");
                });
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}