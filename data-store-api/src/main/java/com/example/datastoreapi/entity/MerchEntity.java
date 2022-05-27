package com.example.datastoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "merch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String merchId;

    @Column(nullable = false, length = 50)
    private String header;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false, length = 50)
    private String brandName;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @Column(columnDefinition = "integer default 0")
    private int votes;

    @Column(nullable = false)
    private String ownerId;
}
