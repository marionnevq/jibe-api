package com.ssglobal.revalida.jibe.controller;

import com.ssglobal.revalida.jibe.dto.PostTagDTO;
import com.ssglobal.revalida.jibe.dto.TagReferenceDTO;
import com.ssglobal.revalida.jibe.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping("/tag")
    public ResponseEntity<TagReferenceDTO> addTagReference(@RequestBody TagReferenceDTO request) {
        return ResponseEntity.ok().body(tagService.createTagReference(request));
    }

    @PostMapping("/tag/{postID}")
    public ResponseEntity<PostTagDTO> addTagToPost(@RequestBody PostTagDTO request, @PathVariable Integer postID) {
        return ResponseEntity.ok().body(tagService.createPostTag(request, postID));
    }


}
