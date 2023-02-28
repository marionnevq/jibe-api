package com.ssglobal.revalida.jibe.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.FollowDTO;
import com.ssglobal.revalida.jibe.model.Follow;
import com.ssglobal.revalida.jibe.repository.FollowRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final ModelMapper modelMapper;

    public FollowDTO createFollow(FollowDTO request) {
        var follower = userRepository.findById(request.getFollowerID());
        var followee = userRepository.findByUsername(request.getFolloweeUsername());

        if(follower.isEmpty() || followee.isEmpty()) {
            throw new RuntimeException("invalid follow");
        }

        var follow = Follow.builder()
                .follower(follower.get())
                .followee(followee.get())
                .build();

        return modelMapper.map(followRepository.save(follow), FollowDTO.class);
    }

    public List<FollowDTO> getFollows(String username) {
        var user = userRepository.findByUsername(username);

        if(user.isEmpty()) {
            throw new RuntimeException("user not found");
        }

        var follows = followRepository.findByFollower_Username(username);

        return follows.stream().map((follow) -> { return modelMapper.map(follow, FollowDTO.class);}).toList();
    }

    public FollowDTO deleteFollow(FollowDTO request) {
        var following = followRepository.findByFollower_IdOrderByFollower_FirstnameDesc(request.getFollowerID());
        var follow = followRepository.findByFollowID(request.getFollowID());

        if(follow.isEmpty()) {
            throw new RuntimeException("follow does not exist");
        }

        followRepository.deleteById(follow.get().getFollowID());

        return modelMapper.map(follow.get(),FollowDTO.class);
    }
}
