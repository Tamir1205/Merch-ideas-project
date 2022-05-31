package com.example.datastoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DislikeRequest {
    private String dislikeId;

    private String merchId;

    private String userId;
}
