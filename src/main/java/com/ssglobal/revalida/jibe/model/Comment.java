package com.ssglobal.revalida.jibe.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "_comment")
public class Comment {

	@Id
	@Column(nullable = false, updatable = false)
	@SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
	private Integer commentID;

	@Column(nullable = false)
	private String value;

//	@Column(nullable = false)
//	private Integer userID;
//
//	@Column(nullable = false)
//	private Integer postID;

	@Column(nullable = false)
	private LocalDate dateCommented;

	private String media;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "post_post_id")
	private Post post;

//
//	@OneToMany(mappedBy = "likedComment")
//	private Set<Likes> likedCommentLikess;
//
//	@OneToMany(mappedBy = "postComments")
//	private Set<Post> postCommentsPosts;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_comment_id")
//	private User userComment;
}
