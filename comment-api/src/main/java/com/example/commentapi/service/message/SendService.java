package com.example.commentapi.service.message;

import com.example.commentapi.model.CommentDTO;

public interface SendService {
    CommentDTO send(CommentDTO commentDTO);

}
