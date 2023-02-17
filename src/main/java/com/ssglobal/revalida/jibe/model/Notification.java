package com.ssglobal.revalida.jibe.model;

import jakarta.persistence.Column;
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
@Table(name = "_notification")
public class Notification {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer userID;

    @Column(nullable = false)
    private String field;

}
