package com.ssglobal.revalida.jibe.service;

import java.util.List;

import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.model.Notification;
import com.ssglobal.revalida.jibe.repository.NotificationRepository;
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
    private final NotificationRepository notificationRepository;

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

        var notif = Notification.builder()
                .userID(followee.get().getId())
                .field(String.format("%s followed you",follower.get().getUsername()))
                .url(String.format("/profile/visit/%s",follower.get().getUsername()))
                .build();
        notificationRepository.save(notif);
        return modelMapper.map(followRepository.save(follow), FollowDTO.class);
    }

    public List<UserDTO> getFollows(String username) {
//        var user = userRepository.findByUsername(username);
        var users = userRepository.findByFollowedBys_Follower_Username(username);



        return users.stream().map((user) -> {
            return modelMapper.map(user, UserDTO.class);
        }).toList();
    }

    public FollowDTO deleteFollow(FollowDTO request) {
        var follow = followRepository.findByFollower_IdAndFollowee_Username(request.getFollowerID(), request.getFolloweeUsername());


        if(follow.isEmpty()) {
            throw new RuntimeException("follow does not exist");
        }

        followRepository.delete(follow.get());

        return modelMapper.map(follow.get(),FollowDTO.class);
    }

    public Boolean checkFollowing(String email, String otherUsername) {
        var user = userRepository.findByEmail(email)
                .or(() -> {return userRepository.findByUsername(email);});

        var otherUser = userRepository.findByUsername(otherUsername);
        if (user.isEmpty() || otherUser.isEmpty()){
            throw new RuntimeException("user not found");
        }
        var foundOtherUser = otherUser.get();
        var foundUser = user.get();

        return followRepository.existsByFollowerAndFollowee(foundUser,foundOtherUser);


    }
}
