package com.ssglobal.revalida.jibe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.dto.CommentDTO;
import com.ssglobal.revalida.jibe.service.CommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

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
    
    @PutMapping("/posts/update/{commentID}")
    public ResponseEntity<Void> updateComment(@PathVariable final Integer commentID,
            @RequestBody @Valid final CommentDTO commentDTO) {
        commentService.update(commentID, commentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> removeCommentById(@PathVariable Integer postId, @PathVariable Integer commentId) {
        return ResponseEntity.ok().body(commentService.removeCommentById(postId,commentId));
    }

}
