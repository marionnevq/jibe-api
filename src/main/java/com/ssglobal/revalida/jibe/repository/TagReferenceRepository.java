package com.ssglobal.revalida.jibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssglobal.revalida.jibe.model.TagReference;

import java.util.Optional;


public interface TagReferenceRepository extends JpaRepository<TagReference, Integer> {
    Optional<TagReference> findByTagValueIgnoreCase(String tagValue);
}
