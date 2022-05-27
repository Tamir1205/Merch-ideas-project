package com.example.commentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchModel {
    private Long id;

    private String merchId;

    private String header;

    private String description;

    private String brandName;

    private String imageUrl;

    private CategoryResponse category;

    private int votes;

    private String ownerId;
}
