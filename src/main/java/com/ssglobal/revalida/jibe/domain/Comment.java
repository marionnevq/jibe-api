package com.ssglobal.revalida.jibe.domain;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

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
	@GeneratedValue
	private Integer commentID;

	@Column(nullable = false)
	private String value;

	@Column(nullable = false)
	private Integer userID;

	@Column
	private Integer postID;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDate dateCommented;

	@Column
	private String media;

	@OneToMany(mappedBy = "likedComment")
	private Set<Likes> likedCommentLikess;

	@OneToMany(mappedBy = "postComments")
	private Set<Post> postCommentsPosts;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_comment_id")
	private User userComment;
}
