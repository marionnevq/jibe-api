package com.ssglobal.revalida.jibe.service;



import java.util.ArrayList;
import java.util.List;

import com.ssglobal.revalida.jibe.dto.PasswordDTO;
import com.ssglobal.revalida.jibe.repository.PasswordTokenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.RegisterRequestDTO;
import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.dto.UserResponseDTO;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.FollowRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
	private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;
    private final PasswordTokenRepository passwordTokenRepository;

    public UserDTO getCurrentUser(String email) {
        var user = userRepository.findByEmail(email)
                .or(() -> {return userRepository.findByUsername(email);});

        if (user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var foundUser = user.get();
        Integer numPosts = Math.toIntExact(postRepository.countByUser(foundUser));
        Integer numFollowers = Math.toIntExact(followRepository.countByFollowee(foundUser));
        Integer numFollowing = Math.toIntExact(followRepository.countByFollower(foundUser));

        UserDTO userDTO = modelMapper.map(foundUser, UserDTO.class);
        userDTO.setPostsCount(numPosts);
        userDTO.setFollowersCount(numFollowers);
        userDTO.setFollowingCount(numFollowing);
        return  userDTO;
//        return UserResponseDTO.builder()
//                .firstname(foundUser.getFirstname())
//                .lastname(foundUser.getLastname())
//                .bio(foundUser.getBio())
//                .imageUrl(foundUser.getImageUrl())
//                .email(foundUser.getEmail())
//                .username(foundUser.getUsername())
//                .build();


    }

    public List<UserResponseDTO> findUsersByUsername(String searchQuery) {

        var user = userRepository.findByUsernameLikeIgnoreCase(searchQuery);

        if (user.isEmpty()){
            return new ArrayList<>();
        }

        return user.stream().map(u -> {
            return modelMapper.map(u, UserResponseDTO.class);

        }).toList();
    }
    
    public UserResponseDTO getUserByUsername(String username) {
//        var user = userRepository.findByUsername(username);
        var user = userRepository.findByUsername(username);

        if (user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var foundUser = user.get();
        Integer numPosts = Math.toIntExact(postRepository.countByUser(foundUser));
        Integer numFollowers = Math.toIntExact(followRepository.countByFollowee(foundUser));
        Integer numFollowing = Math.toIntExact(followRepository.countByFollower(foundUser));

        UserResponseDTO userResponse = modelMapper.map(foundUser, UserResponseDTO.class);
        userResponse.setPostsCount(numPosts);
        userResponse.setFollowersCount(numFollowers);
        userResponse.setFollowingCount(numFollowing);
        return userResponse;

//        return UserResponseDTO.builder()
//                .firstname(foundUser.getFirstname())
//                .lastname(foundUser.getLastname())
//                .bio(foundUser.getBio())
//                .imageUrl(foundUser.getImageUrl())
//                .email(foundUser.getEmail())
//                .username(foundUser.getUsername())
//                .build();
    }
    
    public boolean update(final UserDTO userDTO, String token) {
    	final String jwt = token.substring(7);
		String username = jwtService.extractUsername(jwt);
		User user = userRepository.findByUsername(username)
				.orElseThrow(NotFoundException::new);
		
		if(userDTO.getBio() != null) {
			user.setBio(userDTO.getBio());
		}
		
		if(userDTO.getFirstname() != null) {
			user.setFirstname(userDTO.getFirstname());
		}
				
		if(userDTO.getLastname() != null) {
			user.setLastname(userDTO.getLastname());
		}
		
		if(userDTO.getEmail() != null) {
			user.setEmail(userDTO.getEmail());
		}
		
		if(userDTO.getImageUrl() != null) {
			user.setImageUrl(userDTO.getImageUrl());
		}
		
		if(userDTO.getPassword() != null) {
			user.setPassword(userDTO.getPassword());
		}
		
		if(userDTO.getUsername() != null) {
			user.setUsername(userDTO.getUsername());
		}
		
		if(userDTO.getBirthday() != null) {
			user.setBirthday(userDTO.getBirthday());
		}
		


        if(userDTO.getFirstTimeLogin() != null) {
            user.setFirstTimeLogin(userDTO.getFirstTimeLogin());
        }
		
		userRepository.save(user);

		return true;
    }

    public List<UserResponseDTO> getRandomUsers(Integer count, Integer userID) {
        var accounts = userRepository.findByIdNot(userID, count);


        return accounts.stream().map((user) -> {
            return modelMapper.map(user, UserResponseDTO.class);
        }).toList();
    }

    public Boolean confirmChanges(Integer userID,RegisterRequestDTO request) {
        User user = userRepository.findById(userID)
                .orElseThrow(NotFoundException::new);

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }

    public Boolean updatePassword(PasswordDTO request, String token) {
        final String jwt = token.substring(7);

        var passwordToken =  passwordTokenRepository.findByToken(jwt);
        if(passwordToken.isEmpty()) {
            throw new NotFoundException();
        }

        String username = jwtService.extractUsername(jwt);

        User user = userRepository.findByUsername(username)
                .orElseThrow(NotFoundException::new);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        passwordTokenRepository.delete(passwordToken.get());

        userRepository.save(user);
        return true;



    }
}