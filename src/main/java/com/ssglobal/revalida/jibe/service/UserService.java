package com.ssglobal.revalida.jibe.service;



import com.ssglobal.revalida.jibe.dto.UserResponseDTO;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserResponseDTO getCurrentUser(String email) {
        var user = userRepository.findByEmail(email);

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
}