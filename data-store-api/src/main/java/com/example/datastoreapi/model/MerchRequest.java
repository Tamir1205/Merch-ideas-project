package com.example.datastoreapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchRequest {
    private Long id;

    private String merchId;

    private String header;

    private String description;

    private String brandName;

    private String imageUrl;

    private Long category;

    private int votes;

    private String ownerId;
}
