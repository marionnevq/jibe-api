package com.ssglobal.revalida.jibe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    @GeneratedValue
    private Integer followID;

    @Column(nullable = false)
    private Integer followerID;

    @Column(nullable = false)
    private Integer followeeID;
    
    @OneToOne(mappedBy = "userFollow", fetch = FetchType.LAZY)
    private User userFollow;
}
