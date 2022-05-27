package com.example.commentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private String text;

    private String userId;

    private String merchId;

    private String parentComment;

}
