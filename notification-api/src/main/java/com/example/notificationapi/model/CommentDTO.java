package com.example.notificationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO {
    private String commentId;
    private String authorId;
    private String text;
    private String merchId;
    private String parentCommentId;

}
