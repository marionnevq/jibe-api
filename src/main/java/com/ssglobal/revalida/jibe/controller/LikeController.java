package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.CheckLikeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.dto.LikesDTO;
import com.ssglobal.revalida.jibe.service.LikesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LikeController {

	private final LikesService likesService;

	@PostMapping("/likes")
    public ResponseEntity<Object> createLikes(@RequestBody LikesDTO request, @RequestHeader(name = "Authorization") String token) {
		String error = "";
		try {
	        return ResponseEntity.ok().body(likesService.createLike(request, token));

		}catch (Exception e) {
			error = "Not Found";
		}
		return ResponseEntity.status(400).body(error);
    }
	
	@GetMapping("/likes/{postID}")
    public ResponseEntity<LikesDTO> selectPostLikes(@PathVariable Integer postID) {
        return ResponseEntity.ok().body(likesService.getPostLikes(postID));
    }
	@GetMapping("/likes/{postID}/{userID}")
	public ResponseEntity<LikesDTO> selectPostLikes(@PathVariable Integer postID,@PathVariable Integer userID) {
		CheckLikeDTO request =  CheckLikeDTO.builder()
				.postId(postID)
				.userId(userID)
				.build();
		return ResponseEntity.ok().body(likesService.getLike(request));
	}
	@DeleteMapping("/likes/{reactionID}")
	public ResponseEntity<Void> deleteLike(@PathVariable final Integer reactionID){
		likesService.deleteLike(reactionID);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/likes/exist")
	public ResponseEntity<Boolean> checkLike(@RequestBody CheckLikeDTO request) {
		return ResponseEntity.ok().body(likesService.checkLike(request));
	}
}
