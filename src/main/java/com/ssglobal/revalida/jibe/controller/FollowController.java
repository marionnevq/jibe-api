package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.FollowDTO;
import com.ssglobal.revalida.jibe.dto.UserDTO;
import com.ssglobal.revalida.jibe.security.JwtService;
import com.ssglobal.revalida.jibe.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;
    private final JwtService jwtService;

    @PostMapping()
    public ResponseEntity<FollowDTO> followUser(@RequestBody FollowDTO request) {
        return ResponseEntity.ok().body(followService.createFollow(request));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<UserDTO>> selectFollows(@PathVariable String username) {
        return ResponseEntity.ok().body(followService.getFollows(username));
    }

    @DeleteMapping()
    public ResponseEntity<FollowDTO> removeFollow(@RequestBody FollowDTO request) {
        return ResponseEntity.ok().body(followService.deleteFollow(request));
    }

    @GetMapping("/check/{otherUsername}")
    public ResponseEntity<Boolean> checkFollowing(@RequestHeader(name = "Authorization") String token, @PathVariable String otherUsername) {
        final String jwt = token.substring(7);
        final String userEmail = jwtService.extractUsername(jwt);
        return ResponseEntity.ok().body(followService.checkFollowing(userEmail,otherUsername));
    }
}
