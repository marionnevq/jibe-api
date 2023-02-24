package com.ssglobal.revalida.jibe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssglobal.revalida.jibe.dto.PostTagDTO;
import com.ssglobal.revalida.jibe.dto.TagReferenceDTO;
import com.ssglobal.revalida.jibe.service.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

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

    @PutMapping("/update/{tagID}")
    public ResponseEntity<Void> updatePostTag(@PathVariable final Integer tagID,
            @RequestBody @Valid final TagReferenceDTO tagReferenceDTO) {
        tagService.update(tagID, tagReferenceDTO);
        return ResponseEntity.ok().build();
    }

}
