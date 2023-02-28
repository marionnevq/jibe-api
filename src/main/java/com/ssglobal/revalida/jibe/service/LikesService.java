package com.ssglobal.revalida.jibe.service;
import com.ssglobal.revalida.jibe.dto.CheckLikeDTO;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.LikesDTO;
import com.ssglobal.revalida.jibe.model.Likes;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.LikesRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikesService {

	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final JwtService jwtService;
	private final LikesRepository likesRepository;
	private final PostRepository postRepository;

	public LikesDTO createLike(LikesDTO request, String token) {
		final String jwt = token.substring(7);
		String username = jwtService.extractUsername(jwt);
		User user = userRepository.findByUsername(username)
				.orElseThrow(NotFoundException::new);
		var commentID = 0;
		var postID = 0;
		if (request.getCommentID() == null) {
			postID = request.getPostID();
		} else if (request.getPostID() == null) {
			commentID = request.getCommentID();
		} else {
			throw new RuntimeException("Not Found.");
		}

		var like = Likes.builder()
				.postID(postID)
				.commentID(commentID)
				.userID(user.getId())
				.build();

		var saved = likesRepository.save(like);
		return modelMapper.map(saved, LikesDTO.class);
	}

	public LikesDTO getPostLikes(Integer postID) {
		var post = likesRepository.findById(postID);
		return modelMapper.map(post, LikesDTO.class);
	}

	public LikesDTO getLike(CheckLikeDTO request) {
		var user = userRepository.findById(request.getUserId());

		var post = postRepository.findById(request.getPostId());
		var like = likesRepository.findByUserIDAndPostID(user.get().getId(), post.get().getPostID());
		return modelMapper.map(like.get(), LikesDTO.class);
	}
	
	public boolean deleteLike(Integer reactionID) {
		final Likes like = likesRepository.findById(reactionID)
				.orElseThrow(() -> new NotFoundException());
		likesRepository.delete(like);
		return true;
	}

    public Boolean checkLike(CheckLikeDTO request) {
		var user = userRepository.findById(request.getUserId());

		var post = postRepository.findById(request.getPostId());



		return likesRepository.existsByUserIDAndPostID(user.get().getId(), post.get().getPostID());
    }
}
