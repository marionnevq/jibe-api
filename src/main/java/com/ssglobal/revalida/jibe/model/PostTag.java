package com.ssglobal.revalida.jibe.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "_postTags")
public class PostTag {

	@Id
	@Column(nullable = false, updatable = false)
	@SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
	private Integer postID;

	@Column(nullable = false)
	private Integer tagID;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "post_tags_id")
//	private Post postTags;
//
//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "post_ref", joinColumns = @JoinColumn(name = "post_tag_postid"), inverseJoinColumns = @JoinColumn(name = "tag_reference_tagid"))
//	private Set<TagReference> postRefTagReferences;

}
