package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.AuthenticationRequestDTO;

import com.ssglobal.revalida.jibe.dto.RegisterRequestDTO;
import com.ssglobal.revalida.jibe.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestDTO request) {
        String error = "";
        try {
            return ResponseEntity.ok(authenticationService.register(request));
        } catch (Exception e) {
            error = e.getMessage();
        }
        return ResponseEntity.status(409).body(error);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequestDTO request) {
        String error = "";
//        return ResponseEntity.ok().body(request);
        try {
            return ResponseEntity.ok(authenticationService.authenticate(request));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            if (e instanceof BadCredentialsException) {
                error = "Invalid Credentials";
            } else {
                error = e.getMessage();
            }
        }

        return ResponseEntity.status(401).body(error);

    }


}