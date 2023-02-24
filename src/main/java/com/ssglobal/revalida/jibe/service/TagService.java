package com.ssglobal.revalida.jibe.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ssglobal.revalida.jibe.dto.PostTagDTO;
import com.ssglobal.revalida.jibe.dto.TagReferenceDTO;
import com.ssglobal.revalida.jibe.model.PostTag;
import com.ssglobal.revalida.jibe.model.TagReference;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.PostTagRepository;
import com.ssglobal.revalida.jibe.repository.TagReferenceRepository;
import com.ssglobal.revalida.jibe.util.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagReferenceRepository tagReferenceRepository;
    private final PostTagRepository postTagRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public TagReferenceDTO createTagReference(TagReferenceDTO request) {
        request.setTagValue(request.getTagValue().toLowerCase());
        var tag = modelMapper.map(request, TagReference.class);
        var saved = tagReferenceRepository.save(tag);
        return modelMapper.map(saved, TagReferenceDTO.class);
    }

    public PostTagDTO createPostTag(PostTagDTO request, Integer postID) {
        var post = postRepository.findById(postID);
        if (post.isEmpty()) {
            throw new RuntimeException("post not found");
        }

        var tag = tagReferenceRepository.findByTagValueIgnoreCase(request.getTagValue());

        if(tag.isEmpty()) {
            var tagReference = TagReference.builder()
                    .tagValue(request.getTagValue())
                    .build();
            var saved = tagReferenceRepository.save(tagReference);

            var postTag = PostTag.builder()
                    .post(post.get())
                    .tagReference(saved)
                    .build();

            return modelMapper.map(postTagRepository.save(postTag),PostTagDTO.class);
        } else {

            var postTag = PostTag.builder()
                    .post(post.get())
                    .tagReference(tag.get())
                    .build();
            return modelMapper.map(postTagRepository.save(postTag),PostTagDTO.class);
        }
    }
    
    public boolean update(final Integer tagID, final TagReferenceDTO tagReferenceDTO) {
    	final TagReference tag = tagReferenceRepository.findById(tagID)
    			.orElseThrow(NotFoundException::new);
    	mapToEntity(tagReferenceDTO, tag);
    	boolean isSuccess = tagReferenceRepository.save(tag) != null;
    	return isSuccess;
    }
    
    private TagReference mapToEntity(final TagReferenceDTO tagReferenceDTO, final TagReference tagReference) {
    	tagReference.setTagValue(tagReferenceDTO.getTagValue());
    	return tagReference;
    }
}
