package com.example.notificationapi.service.consume;

import com.example.notificationapi.model.CommentDTO;
import com.example.notificationapi.model.MerchDTO;

import java.util.List;

public interface ConsumeService {
    void consumeMerchMessage(MerchDTO merchDTOS);

    void consumeCommentMessage(CommentDTO commentDTOS);
}
