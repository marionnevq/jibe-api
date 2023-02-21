package com.ssglobal.revalida.jibe.service;

import com.ssglobal.revalida.jibe.dto.AuthenticationRequest;
import com.ssglobal.revalida.jibe.dto.AuthenticationResponse;
import com.ssglobal.revalida.jibe.dto.RegisterRequest;
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

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws EntityExistsException, Exception {

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
                .imageUrl(request.getImageUrl())
                .firstTimeLogin(true)
                .role(Role.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws BadCredentialsException,Exception {
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
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
