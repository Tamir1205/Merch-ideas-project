package com.example.datastoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchResponse {
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
