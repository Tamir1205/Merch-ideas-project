package com.example.datastoreapi.service;

import com.example.datastoreapi.model.DislikeRequest;
import com.example.datastoreapi.model.DislikeResponse;

public interface DislikeService {
    DislikeResponse createDislike(DislikeRequest dislikeRequest);

    int getDislikesByMerchId(String merchId);

    boolean getDislikeByMerchIdAndUserId(String merchId, String userId);

    void deleteDislikeByMerchIdAndUserId(String merchId, String userId);
}
