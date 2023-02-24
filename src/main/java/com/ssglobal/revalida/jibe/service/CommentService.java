package com.ssglobal.revalida.jibe.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.CommentDTO;
import com.ssglobal.revalida.jibe.model.Comment;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;

    public CommentDTO createComment(CommentDTO request, Integer id) {
        var user = userRepository.findById(request.getUserID());
        var post = postRepository.findById(id);

        if(post.isEmpty() || user.isEmpty()) {
            throw new RuntimeException("invalid comment");
        }

        var comment = Comment.builder()
                .user(user.get())
                .post(post.get())
                .value(request.getValue())
                .media(request.getMedia())
                .dateCommented(LocalDate.now())
                .build();

        var saved = commentRepository.save(comment);

        return  modelMapper.map(saved,CommentDTO.class);
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
        return comments.stream().map(comment -> modelMapper.map(comment,CommentDTO.class)).toList();
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
    
    public void update(final Integer commentID, final CommentDTO commentDTO) {
        final Comment comment = commentRepository.findById(commentID)
                .orElseThrow(NotFoundException::new);
        mapToEntity(commentDTO, comment);
        commentRepository.save(comment);
    }
    
    private Comment mapToEntity(final CommentDTO commentDTO, final Comment comment) {
        comment.setValue(commentDTO.getValue());
		return comment;
    }
}
