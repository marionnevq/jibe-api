package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.FollowDTO;
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

    @PostMapping()
    public ResponseEntity<FollowDTO> followUser(@RequestBody FollowDTO request) {
        return ResponseEntity.ok().body(followService.createFollow(request));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<FollowDTO>> selectFollows(@PathVariable String username) {
        return ResponseEntity.ok().body(followService.getFollows(username));
    }

    @DeleteMapping()
    public ResponseEntity<FollowDTO> removeFollow(@RequestBody FollowDTO request) {
        return ResponseEntity.ok().body(followService.deleteFollow(request));
    }
}
