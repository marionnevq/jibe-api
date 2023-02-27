package com.ssglobal.revalida.jibe.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.CommentDTO;
import com.ssglobal.revalida.jibe.model.Comment;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	private final ModelMapper modelMapper;
	private final JwtService jwtService;

	public CommentDTO createComment(CommentDTO request, Integer id) {
		var user = userRepository.findById(request.getUserID());
		var post = postRepository.findById(id);

		if (post.isEmpty() || user.isEmpty()) {
			throw new RuntimeException("invalid comment");
		}

		var comment = Comment.builder().user(user.get()).post(post.get()).value(request.getValue())
				.media(request.getMedia()).dateCommented(LocalDate.now()).build();

		var saved = commentRepository.save(comment);

		return modelMapper.map(saved, CommentDTO.class);
//        return CommentDTO.builder()
//                .commentID(saved.getCommentID())
//                .dateCommented(saved.getDateCommented())
//                .media(saved.getMedia())
//                .postID(saved.getPost().getPostID())
//                .userID(saved.getUser().getId())
//                .value(saved.getValue())
//                .build();
	}

	public List<CommentDTO> getComments(Integer id) {
		var comments = commentRepository.findByPost_PostIDOrderByDateCommentedDesc(id);
		return comments.stream().map(comment -> modelMapper.map(comment, CommentDTO.class)).toList();
	}

	public CommentDTO removeCommentById(Integer postId, Integer commentId) {
		var post = postRepository.findById(postId);

		var comment = commentRepository.findById(commentId);

		if (post.isEmpty() || comment.isEmpty()) {
			throw new RuntimeException("invalid delete");
		}

		commentRepository.deleteById(commentId);

		return modelMapper.map(comment.get(), CommentDTO.class);
	}

	public String update(final Integer commentID, final CommentDTO commentDTO, String token) {
		String message = "You don't have any access to this field.";
		final Comment comment = commentRepository.findById(commentID).orElseThrow(NotFoundException::new);
		final String jwt = token.substring(7);
		String username = jwtService.extractUsername(jwt);
		User user = userRepository.findByUsername(username).orElseThrow(NotFoundException::new);

		if (user.getId() != comment.getUser().getId()) {
			return message;
		}
		
		if (commentDTO.getValue() != null) {
			comment.setValue(commentDTO.getValue());
		}

		if (commentDTO.getMedia() != null) {
			comment.setMedia(commentDTO.getMedia());
		}

		if (commentDTO.getDateCommented() != null) {
			comment.setDateCommented(commentDTO.getDateCommented());
		}
		
		commentRepository.save(comment);
		return "Successfully Updated.";
	}
}
