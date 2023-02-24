package com.ssglobal.revalida.jibe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.dto.UserResponseDTO;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.service.PostService;
import com.ssglobal.revalida.jibe.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;

    private final JwtService jwtService;


    @GetMapping("/users/me")
    public ResponseEntity<UserResponseDTO> selectCurrentUser(@RequestHeader(name = "Authorization") String token) {
        final String jwt = token.substring(7);
        final String userEmail = jwtService.extractUsername(jwt);
        return ResponseEntity.ok().body(userService.getCurrentUser(userEmail));
    }


    @GetMapping("/profiles")
    public ResponseEntity<List<UserResponseDTO>> searchUsersByUsername(@RequestBody String searchQuery) {
        return ResponseEntity.ok(userService.findUsersByUsername(String.format("%%%s%%",searchQuery)));

    }

    @GetMapping("/profiles/{username}")
    public ResponseEntity<UserResponseDTO> selectUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));

    }

    @GetMapping("/profiles/{username}/posts")
    public ResponseEntity<List<PostDTO>> selectPostsByUser(@PathVariable String username) {
        return ResponseEntity.ok(postService.getPostsByUser(username));

    }
    
    @PutMapping("/profiles/update")
    public ResponseEntity<Boolean> updateUser(@RequestBody @Valid final UserDTO userDTO, @RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok().body(userService.update(userDTO, token));
    }

}
