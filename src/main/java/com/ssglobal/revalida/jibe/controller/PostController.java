package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping()
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO request) {
        return ResponseEntity.ok().body(postService.createPost(request));
    }
    @GetMapping()
    public ResponseEntity<List<PostDTO>> selectAllPosts() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> selectPostById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(postService.getPostById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO> removePostById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(postService.deletePostById(id));
    }
}
