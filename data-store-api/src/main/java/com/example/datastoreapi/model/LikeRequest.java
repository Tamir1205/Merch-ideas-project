package com.example.datastoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikeRequest {
    private String likeId;

    private String merchId;

    private String userId;
}
