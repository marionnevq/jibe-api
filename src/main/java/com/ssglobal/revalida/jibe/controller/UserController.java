package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.UserResponse;
import com.ssglobal.revalida.jibe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/me")
    public ResponseEntity<UserResponse> selectCurrentUser(@RequestBody String email) {
        return ResponseEntity.ok(userService.getCurrentUser(email));
    }


    @GetMapping("/profiles")
    public ResponseEntity<List<UserResponse>> searchUsersByUsername(@RequestBody String searchQuery) {

        return ResponseEntity.ok(userService.findUsersByUsername(String.format("%%%s%%",searchQuery)));

    }

    @GetMapping("/profiles/{username}")
    public ResponseEntity<UserResponse> selectUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));

    }


}
