package com.ssglobal.revalida.jibe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.model.CommentDTO;
import com.ssglobal.revalida.jibe.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

	private final CommentService commentService;

	public CommentController(final CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping
	public ResponseEntity<List<CommentDTO>> getAllComments() {
		return ResponseEntity.ok(commentService.findAll());
	}
	
    @GetMapping("/comment/{commentID}")
    public ResponseEntity<CommentDTO> getComment(@PathVariable final Integer commentID) {
        return ResponseEntity.ok(commentService.get(commentID));
    }
	
    @PostMapping("/posts")
    public ResponseEntity<Boolean> createComment(@RequestBody @Valid final CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.create(commentDTO), HttpStatus.CREATED);
    }
    
//    @DeleteMapping("/posts/{postID}/comments/{commentID}")
//    public ResponseEntity<Void> deleteComment(@PathVariable final Integer commentID) {
//        commentService.delete(commentID);
//        return ResponseEntity.noContent().build();
//    }
    
}
