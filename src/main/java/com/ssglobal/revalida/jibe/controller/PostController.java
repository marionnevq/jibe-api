package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.service.PostService;

import com.ssglobal.revalida.jibe.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO request) {
        return ResponseEntity.ok().body(postService.createPost(request));
    }
    
    @GetMapping()
    public ResponseEntity<List<PostDTO>> selectAllPosts() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }
    
    @PutMapping("/update/{postID}")
    public ResponseEntity<Void> updatePost(@PathVariable final Integer postID,
            @RequestBody @Valid final PostDTO postDTO) {
        postService.update(postID, postDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> selectPostById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(postService.getPostById(id));
    }

    @GetMapping("/following")
    public ResponseEntity<List<PostDTO>> getFollowingPosts(@RequestHeader(name = "Authorization") String token) {
        final String jwt = token.substring(7);
        final String username = jwtService.extractUsername(jwt);
//        return ResponseEntity.ok(username);
        return ResponseEntity.ok().body(postService.getFollowingPosts(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO> removePostById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(postService.deletePostById(id));
    }


}
