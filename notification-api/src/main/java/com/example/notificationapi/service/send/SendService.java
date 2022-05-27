package com.example.notificationapi.service.send;

import com.example.notificationapi.model.CommentDTO;
import com.example.notificationapi.model.MerchDTO;

import java.util.List;

public interface SendService {
    void sendMerch(MerchDTO merchDTO);

    void sendComment(CommentDTO commentDTO);
}
