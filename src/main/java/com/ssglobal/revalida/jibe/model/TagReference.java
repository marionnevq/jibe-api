package com.ssglobal.revalida.jibe.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_tagReference")
public class TagReference {

    @Id
    @GeneratedValue
    private Integer tagID;

    @Column(nullable = false)
    private String tagValue;

    @Column(nullable = false)
    private String field;
    
    @ManyToMany(mappedBy = "postRefTagReferences")
    private Set<PostTag> postRefPostTags;

}
