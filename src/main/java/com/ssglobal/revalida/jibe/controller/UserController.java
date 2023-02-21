package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.dto.UserResponseDTO;
import com.ssglobal.revalida.jibe.service.PostService;
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
    private final PostService postService;

    @GetMapping("/users/me")
    public ResponseEntity<UserResponseDTO> selectCurrentUser(@RequestBody String email) {
        return ResponseEntity.ok(userService.getCurrentUser(email));
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


}
