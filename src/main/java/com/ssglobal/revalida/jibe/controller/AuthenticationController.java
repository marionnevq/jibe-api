package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.AuthenticationRequestDTO;

import com.ssglobal.revalida.jibe.dto.PasswordDTO;
import com.ssglobal.revalida.jibe.dto.RegisterRequestDTO;
import com.ssglobal.revalida.jibe.dto.RequestPasswordDTO;
import com.ssglobal.revalida.jibe.service.AuthenticationService;
import com.ssglobal.revalida.jibe.service.PasswordService;
import com.ssglobal.revalida.jibe.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final PasswordService passwordService;

    private final JavaMailSender mailSender;
    private final UserService userService;
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

    @PostMapping("/request")
    public ResponseEntity<Boolean> resetPassword(@RequestBody RequestPasswordDTO request) throws MessagingException, UnsupportedEncodingException {
        String email = request.getEmail();
        String token = passwordService.getResetToken(request);
        String resetPasswordLink = "http://localhost:3000/password/reset/" + token;
        sendEmail(email,resetPasswordLink);
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/password/reset/{token}")
    public ResponseEntity<Boolean> showResetForm(@PathVariable String token) {

        return ResponseEntity.ok().body(passwordService.checkToken(token));
    }

    @PutMapping("/password/save")
    public ResponseEntity<Object> updatePassword(@RequestBody PasswordDTO request, @RequestHeader(name = "Authorization") String token) {
                return ResponseEntity.ok().body(userService.updatePassword(request,token));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequestDTO request) {
        String error = "";
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

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        SimpleMailMessage message = new SimpleMailMessage();


        message.setFrom("contact@jibe.com");
        message.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = """
                Hello
                                You have requested to reset your password.
                                Click the link below to change your password:
                                
                                %s
                                
                                Ignore this email if you do remember your password, 
                                or you have not made the request."
                                
                                -Jibe Support Team
                """;



        message.setSubject(subject);

        message.setText(String.format(content,link));

        mailSender.send(message);
    }


}