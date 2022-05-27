package com.example.datastoreapi.service.message;

import com.example.datastoreapi.entity.MerchEntity;
import com.example.datastoreapi.model.MerchDTO;

public interface SendService {
    MerchDTO send(MerchDTO merchDTO);
}
