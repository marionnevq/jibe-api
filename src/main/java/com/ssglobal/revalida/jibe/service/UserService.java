package com.ssglobal.revalida.jibe.service;



import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.dto.UserResponseDTO;
import com.ssglobal.revalida.jibe.model.User;
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

    public UserDTO getCurrentUser(String email) {
        var user = userRepository.findByEmail(email)
                .or(() -> {return userRepository.findByUsername(email);});

        if (user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var foundUser = user.get();
        return modelMapper.map(foundUser, UserDTO.class);
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
//            return UserResponseDTO.builder()
//                    .username(u.getUsername())
//                    .email(u.getEmail())
//                    .firstname(u.getFirstname())
//                    .lastname(u.getLastname())
//                    .bio(u.getBio())
//                    .imageUrl(u.getImageUrl())
//                    .build();
        }).toList();
    }
    
    public UserResponseDTO getUserByUsername(String username) {
//        var user = userRepository.findByUsername(username);
        var user = userRepository.findByUsername(username);

        if (user.isEmpty()){
            throw new RuntimeException("user not found");
        }

        var foundUser = user.get();
        return modelMapper.map(foundUser, UserResponseDTO.class);

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
}