package com.example.datastoreapi.service;

import com.example.datastoreapi.model.LikeRequest;
import com.example.datastoreapi.model.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;

public interface LikeService {
    LikeResponse createLike(LikeRequest likeRequest);

    int getLikesByMerchId(String merchId);

    boolean getLikeByMerchIdAndUserId(String merchId, String userId);

    void deleteLikeByMerchIdAndUserId(String merchId, String userId);
}
