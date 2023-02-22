package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.CommentDTO;
import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO request, @PathVariable Integer id) {
        return ResponseEntity.ok().body(commentService.createComment(request,id));
    }

    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<List<CommentDTO>> selectComments(@PathVariable Integer id) {
        return ResponseEntity.ok().body(commentService.getComments(id));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> removeCommentById(@PathVariable Integer postId, @PathVariable Integer commentId) {
        return ResponseEntity.ok().body(commentService.removeCommentById(postId,commentId));
    }

}