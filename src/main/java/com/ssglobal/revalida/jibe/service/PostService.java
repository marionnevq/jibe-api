package com.ssglobal.revalida.jibe.service;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public PostDTO createPost(PostDTO request) {
        var user = userRepository.findById(request.getUserID());

        if (user.isEmpty()) {
            throw new RuntimeException("user not found");
        }

        var post = Post.builder()
                .body(request.getBody())
                .imageUrl(request.getImageUrl())
                .user(user.get())
                .datePosted(request.getDatePosted())
                .build();


        var saved = postRepository.save(post);

        return modelMapper.map(saved, PostDTO.class);
//        return PostDTO.builder()
//                .postID(saved.getPostID())
//                .body(saved.getBody())
//                .datePosted(saved.getDatePosted())
//                .userID(saved.getUser().getId())
//                .username(saved.getUser().getUsername())
//                .imageUrl(saved.getImageUrl())
//                .build();
    }

    public List<PostDTO> getAllPosts() {

        var posts = postRepository.findByPostIDNotNullOrderByDatePostedDesc().stream().map(post -> {
            return modelMapper.map(post, PostDTO.class);
//            return PostDTO.builder()
//                    .postID(post.getPostID())
//                    .body(post.getBody())
//                    .datePosted(post.getDatePosted())
//                    .userID(post.getUser().getId())
//                    .username(post.getUser().getUsername())
//                    .imageUrl(post.getImageUrl())
//                    .build();
        }).toList();


        return posts;
    }

    public PostDTO getPostById(Integer id) {
        var post = postRepository.findById(id);

        return modelMapper.map(post, PostDTO.class);
//        return PostDTO.builder()
//                .postID(post.get().getPostID())
//                .body(post.get().getBody())
//                .datePosted(post.get().getDatePosted())
//                .userID(post.get().getUser().getId())
//                .username(post.get().getUser().getUsername())
//                .imageUrl(post.get().getImageUrl())
//                .build();
    }

    public PostDTO deletePostById(Integer id) {
        var post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new RuntimeException("post not found");
        } else {
            postRepository.deleteById(id);
            return modelMapper.map(post.get(), PostDTO.class);
//            return PostDTO.builder()
//                    .postID(post.get().getPostID())
//                    .body(post.get().getBody())
//                    .datePosted(post.get().getDatePosted())
//                    .userID(post.get().getUser().getId())
//                    .username(post.get().getUser().getUsername())
//                    .imageUrl(post.get().getImageUrl())
//                    .build();
        }

    }

    public List<PostDTO> getPostsByUser(String username) {
        var posts = postRepository.findByUser_UsernameOrderByDatePostedDesc(username).stream().map(post -> {
            return modelMapper.map(post, PostDTO.class);
//            return PostDTO.builder()
//                    .postID(post.getPostID())
//                    .body(post.getBody())
//                    .datePosted(post.getDatePosted())
//                    .userID(post.getUser().getId())
//                    .username(post.getUser().getUsername())
//                    .imageUrl(post.getImageUrl())
//                    .build();
        }).toList();


        return posts;
    }
}
