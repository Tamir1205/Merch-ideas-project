package com.example.datastoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dislikes")
public class DislikeEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String dislikeId;

    private String merchId;
    private String userId;
}
