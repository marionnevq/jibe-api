package com.ssglobal.revalida.jibe.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "_likes")
public class Likes {

	@Id
	@Column(nullable = false, updatable = false)
	@SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
	private Integer reactionID;

	@Column(nullable = false)
	private Integer userID;

	@Column(nullable = false)
	private Integer commentID;

	@Column(nullable = false)
	private Integer postID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "liked_comment_id")
	private Comment likedComment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_likes_id", nullable = false)
	private Post postLikes;

    @OneToOne(mappedBy = "userLike", fetch = FetchType.LAZY)
    private User userLike;
}
