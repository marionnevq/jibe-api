package com.ssglobal.revalida.jibe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.domain.Comment;
import com.ssglobal.revalida.jibe.domain.User;
import com.ssglobal.revalida.jibe.model.CommentDTO;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;

	public CommentService(final CommentRepository commentRepository, final UserRepository userRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;

	}

	public List<CommentDTO> findAll() {
		final List<Comment> comments = commentRepository.findAll(Sort.by("commentID"));
		return comments.stream()
				.map((comment) -> mapToDTO(comment, new CommentDTO()))
				.collect(Collectors.toList());
	}

	public CommentDTO get(final Integer commentID) {
		return commentRepository.findById(commentID).map(comment -> mapToDTO(comment, new CommentDTO()))
				.orElseThrow(NotFoundException::new);
	}

	public boolean create(final CommentDTO commentDTO, final String value, final String media) {
		final Comment comment = new Comment();
		if (value != null) {
			throw new RuntimeException("Comment is empty.");
		}
		mapToEntity(commentDTO, comment);
		boolean isSuccess = commentRepository.save(comment) != null;
		return isSuccess;
	}

	public void delete(final Integer commentID) {
		commentRepository.deleteById(commentID);
	}

	private CommentDTO mapToDTO(final Comment comment, final CommentDTO commentDTO) {
		commentDTO.setCommentID(comment.getCommentID());
		commentDTO.setValue(comment.getValue());
		commentDTO.setUserID(comment.getUserID());
		commentDTO.setPostID(comment.getPostID());
		commentDTO.setDateCommented(comment.getDateCommented());
		commentDTO.setUserComment(comment.getUserComment() == null ? null : comment.getUserComment().getId());
		return commentDTO;
	}

	private Comment mapToEntity(final CommentDTO commentDTO, final Comment comment) {
		comment.setValue(commentDTO.getValue());
		comment.setUserID(commentDTO.getUserID());
		comment.setPostID(commentDTO.getPostID());
		comment.setDateCommented(commentDTO.getDateCommented());
		final User userComment = commentDTO.getUserComment() == null ? null
				: userRepository.findById(commentDTO.getUserComment())
						.orElseThrow(() -> new NotFoundException("userComment not found"));
		comment.setUserComment(userComment);
		return comment;
	}
}
