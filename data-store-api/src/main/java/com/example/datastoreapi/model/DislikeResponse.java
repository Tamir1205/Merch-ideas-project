package com.example.datastoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DislikeResponse {
    private String dislikeId;
    private String merchId;
    private String userId;
}
