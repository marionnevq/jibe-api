package com.ssglobal.revalida.jibe.service;

import com.ssglobal.revalida.jibe.dto.UserResponse;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public UserResponse getCurrentUser(String email) {
		var user = userRepository.findByEmail(email);

		if (user.isEmpty()) {
			throw new RuntimeException("user not found");
		}

		var foundUser = user.get();
		return UserResponse.builder().firstname(foundUser.getFirstname()).lastname(foundUser.getLastname())
				.bio(foundUser.getBio()).imageUrl(foundUser.getImageUrl()).email(foundUser.getEmail())
				.username(foundUser.getUsername()).build();

	}

	public List<UserResponse> findUsersByUsername(String searchQuery) {
		var user = userRepository.findByUsernameLikeIgnoreCase(searchQuery);

		if (user.isEmpty()) {
			return new ArrayList<>();
		}

		return user.stream().map(u -> {
			return UserResponse.builder().username(u.getUsername()).email(u.getEmail()).firstname(u.getFirstname())
					.lastname(u.getLastname()).bio(u.getBio()).imageUrl(u.getImageUrl()).build();
		}).toList();
	}

	public UserResponse getUserByUsername(String username) {
		var user = userRepository.findByUsername(username);

		if (user.isEmpty()) {
			throw new RuntimeException("user not found");
		}

		var foundUser = user.get();
		return UserResponse.builder().firstname(foundUser.getFirstname()).lastname(foundUser.getLastname())
				.bio(foundUser.getBio()).imageUrl(foundUser.getImageUrl()).email(foundUser.getEmail())
				.username(foundUser.getUsername()).build();
	}
}
