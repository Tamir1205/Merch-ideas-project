package com.example.datastoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true,nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer numberInSorting;
}
