package com.ssglobal.revalida.jibe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.domain.Comment;
import com.ssglobal.revalida.jibe.domain.Likes;
import com.ssglobal.revalida.jibe.domain.Post;
import com.ssglobal.revalida.jibe.model.LikesDTO;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.LikesRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

@Service
public class LikesService {

	private final LikesRepository likesRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public LikesService(final LikesRepository likesRepository,
            final CommentRepository commentRepository, final PostRepository postRepository) {
        this.likesRepository = likesRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    
    public List<LikesDTO> findAll() {
        final List<Likes> likess = likesRepository.findAll(Sort.by("reactionID"));
        return likess.stream()
                .map((likes) -> mapToDTO(likes, new LikesDTO()))
                .collect(Collectors.toList());
    }
    
    public LikesDTO get(final Integer reactionID) {
        return likesRepository.findById(reactionID)
                .map(likes -> mapToDTO(likes, new LikesDTO()))
                .orElseThrow(NotFoundException::new);
    }
    
    public Integer create(final LikesDTO likesDTO) {
        final Likes likes = new Likes();
        mapToEntity(likesDTO, likes);
        return likesRepository.save(likes).getReactionID();
    }

    public void update(final Integer reactionID, final LikesDTO likesDTO) {
        final Likes likes = likesRepository.findById(reactionID)
                .orElseThrow(NotFoundException::new);
        mapToEntity(likesDTO, likes);
        likesRepository.save(likes);
    }

    public void delete(final Integer reactionID) {
        likesRepository.deleteById(reactionID);
    }
    
    private LikesDTO mapToDTO(final Likes likes, final LikesDTO likesDTO) {
        likesDTO.setReactionID(likes.getReactionID());
        likesDTO.setUserID(likes.getUserID());
        likesDTO.setCommentID(likes.getCommentID());
        likesDTO.setPostID(likes.getPostID());
        likesDTO.setLikedComment(likes.getLikedComment() == null ? null : likes.getLikedComment().getCommentID());
        likesDTO.setPostLikes(likes.getPostLikes() == null ? null : likes.getPostLikes().getPostID());
        return likesDTO;
    }
    

    private Likes mapToEntity(final LikesDTO likesDTO, final Likes likes) {
        likes.setUserID(likesDTO.getUserID());
        likes.setCommentID(likesDTO.getCommentID());
        likes.setPostID(likesDTO.getPostID());
        final Comment likedComment = likesDTO.getLikedComment() == null ? null : commentRepository.findById(likesDTO.getLikedComment())
                .orElseThrow(() -> new NotFoundException("likedComment not found"));
        likes.setLikedComment(likedComment);
        final Post postLikes = likesDTO.getPostLikes() == null ? null : postRepository.findById(likesDTO.getPostLikes())
                .orElseThrow(() -> new NotFoundException("postLikes not found"));
        likes.setPostLikes(postLikes);
        return likes;
    }
    
}
