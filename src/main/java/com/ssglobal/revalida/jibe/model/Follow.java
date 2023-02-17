package com.ssglobal.revalida.jibe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    private Integer followerID;

    private Integer followeeID;
    
    
    

}
