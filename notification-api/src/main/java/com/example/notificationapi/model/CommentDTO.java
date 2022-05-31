package com.example.notificationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO {
    private String newCommentOwnerId;
    private String replyCommentOwnerId;
    private String text;
    private String brandName;
}
