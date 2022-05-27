package com.example.datastoreapi.service;

import com.example.datastoreapi.model.*;

import java.util.List;

public interface MerchService {
    MerchResponse createMerch(MerchRequest merchRequest);

    MerchResponse getMerchById(String merchId);

    List<MerchResponse> getAllMerch();

    List<MerchResponse> getMerchByCategoryId(Long categoryId);

    MerchResponse updateMerch(MerchRequest merchRequest);

    void deleteMerchById(String merchId);

    MerchDTO sendMail(String merchId);
}
