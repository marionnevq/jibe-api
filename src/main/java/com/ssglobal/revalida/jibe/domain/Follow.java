package com.ssglobal.revalida.jibe.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "_follow")
public class Follow {

	@Id
	@Column(nullable = false, updatable = false)
	@SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence", allocationSize = 1, initialValue = 10000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
	private Integer followID;

	@Column(nullable = false)
	private Integer followerID;

	@Column(nullable = false)
	private Integer followeeID;

	@OneToOne(mappedBy = "userFollow", fetch = FetchType.LAZY)
	private User userFollow;
}
