package com.ssglobal.revalida.jibe.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.domain.Post;
import com.ssglobal.revalida.jibe.domain.User;
import com.ssglobal.revalida.jibe.model.PostDTO;
import com.ssglobal.revalida.jibe.model.UserDTO;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

@Service
public class PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;

	public PostService(final PostRepository postRepository, final UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	public List<PostDTO> getAll() {
		final List<Post> posts = postRepository.findAll(Sort.by("postID"));
		return posts.stream()
				.map((post) -> mapToDTO(post, new PostDTO()))
				.collect(Collectors.toList());
	}

	public List<PostDTO> getPostsByUsername(final String username){
		User user = userRepository.findByUsername(username)
				.orElseThrow(NotFoundException::new);
//		UserDTO users = mapToUserDTO(user, new UserDTO());
		final List<Post> posts = postRepository.findPostsByUserID(user.getId());
		return posts.stream()
				.map((post) -> mapToDTO(post, new PostDTO()))
				.collect(Collectors.toList());
	}

	public boolean createPost(final PostDTO postDTO, final String body, final String imageUrl) {
		final Post post = new Post();
		if (body != null) {
			throw new RuntimeException("Post is empty.");
		}
		mapToEntity(postDTO, post);
		boolean isSuccess = postRepository.save(post) != null;
		return isSuccess;
	}

	public PostDTO get(final Integer postID) {
		return postRepository.findByPostID(postID).map(post -> mapToDTO(post, new PostDTO()))
				.orElseThrow(NotFoundException::new);
	}

	public void deletePost(final Integer postID) {
		postRepository.deleteById(postID);
	}

	private PostDTO mapToDTO(final Post post, final PostDTO postDTO) {
		postDTO.setPostID(post.getPostID());
		postDTO.setBody(post.getBody());
		postDTO.setImageUrl(post.getImageUrl());
		postDTO.setUserID(post.getUserID());
		postDTO.setDatePosted(post.getDatePosted());
		return postDTO;
	}

	private Post mapToEntity(final PostDTO postDTO, final Post post) {
		post.setBody(postDTO.getBody());
		post.setImageUrl(postDTO.getImageUrl());
		post.setDatePosted(postDTO.getDatePosted());
		return post;
	}
	
//	private UserDTO mapToUserDTO(final User user, final UserDTO userDTO) {
//		userDTO.setId(user.getId());
//		return userDTO;
//	}

}
