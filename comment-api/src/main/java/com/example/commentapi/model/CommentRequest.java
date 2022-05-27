package com.example.commentapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private String commentId;

    @NotNull
    private String text;

    @NotNull
    private String userId;

    @NotNull
    private String merchId;
    private String parentComment;

}
