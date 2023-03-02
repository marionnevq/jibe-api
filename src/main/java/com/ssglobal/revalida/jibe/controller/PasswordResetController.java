package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.PasswordDTO;
import com.ssglobal.revalida.jibe.dto.RequestPasswordDTO;
import com.ssglobal.revalida.jibe.service.PasswordService;
import com.ssglobal.revalida.jibe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/password")
@RequiredArgsConstructor
public class PasswordResetController {
    private static final String MSG = "resetPassword";

    private final MessageSource messageSource;

    private final PasswordService passwordService;

    private final UserService userService;



    @PutMapping("/save")
    public ResponseEntity<Boolean> updatePassword(@RequestBody PasswordDTO request,@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok().body(userService.updatePassword(request,token));
    }

}
