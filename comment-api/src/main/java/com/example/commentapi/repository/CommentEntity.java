package com.example.commentapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    @Id //sss, ddd
    @Field(type = FieldType.Keyword)
    private String commentId;
    @Field(type=FieldType.Text)
    private String text;
    @Field(type = FieldType.Keyword)
    private String commentAuthor;
    @Field(type=FieldType.Keyword)
    private String merchId;
    @Field(type = FieldType.Keyword)
    private String parentCommentId; //null, sss
}

