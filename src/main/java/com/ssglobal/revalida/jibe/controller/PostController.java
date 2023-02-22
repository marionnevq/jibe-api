package com.ssglobal.revalida.jibe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.model.PostDTO;
import com.ssglobal.revalida.jibe.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

	private final PostService postService;

	public PostController(final PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<List<PostDTO>> getAllPosts() {
		return ResponseEntity.ok(postService.getAll());
	}
	
	@GetMapping("/profiles/{username}/posts")
	public ResponseEntity<List<PostDTO>> getPostByUsername(@PathVariable final String username){
		return ResponseEntity.ok(postService.getPostsByUsername(username));
	}

	@PostMapping
	public ResponseEntity<Boolean> create(@RequestPart("post") @Valid final PostDTO post,
			@RequestPart("body") String body,
			@RequestPart("imageUrl") String imageUrl) {
		return new ResponseEntity<>(postService.createPost(post, body, imageUrl), HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/{postID}")
	public ResponseEntity<PostDTO> findPostByID(@PathVariable final Integer postID){
		return ResponseEntity.ok(postService.get(postID));
	}
	
	@DeleteMapping("/posts/{postID}")
		public ResponseEntity<Void> deletePost(@PathVariable final Integer postID){
			postService.deletePost(postID);
		return ResponseEntity.noContent().build();
	}
}
