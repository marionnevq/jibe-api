package com.ssglobal.revalida.jibe.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.PostDTO;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.repository.FollowRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
	private final JwtService jwtService;
    private final FollowRepository followRepository;


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
    
    public boolean update(final Integer id, final PostDTO postDTO) {
    	final Post post = postRepository.findById(id)
    			.orElseThrow(NotFoundException::new);
    	mapToEntity(postDTO, post);
    	boolean isSuccess = postRepository.save(post) != null;
    	return isSuccess;
    }
    
    private Post mapToEntity(final PostDTO postDTO, final Post post) {
    	post.setBody(postDTO.getBody());
		return post;
    }
    
//    public List<PostDTO> getPostByFollowing(Integer id, String token) {
//    	final String jwt = token.substring(7);
//		String username = jwtService.extractUsername(jwt);
//		User user = userRepository.findByUsername(username)
//				.orElseThrow(NotFoundException::new);
//		return null;
//		
//    }
    	
//    	 final Follow following = followDTO.getFolloweeID() == null ? null : followRepository.findById(followDTO.getFolloweeID())
//                 .orElseThrow(() -> new NotFoundException("Followee Not Found"));
//		return following;


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

    public List<PostDTO> getFollowingPosts(String username) {
        var followingUsers = followRepository.findByFollower_Username(username);
        var followingUserIds = followingUsers.stream().map(follow -> {return  follow.getFollowee().getId();}).toList();
        var posts = postRepository.findByUser_IdInOrderByDatePostedDesc(followingUserIds);

        return posts.stream().map(post -> modelMapper.map(post,PostDTO.class)).toList();
    }
}
