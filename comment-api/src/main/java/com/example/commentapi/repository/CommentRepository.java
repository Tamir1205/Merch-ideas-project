package com.example.commentapi.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends ElasticsearchRepository<CommentEntity, String> {
    List<CommentEntity> getCommentEntitiesBy();

    CommentEntity getCommentEntitiesByCommentId(String commentId);

    void deleteCommentEntitiesByCommentId(String commentId);


    List<CommentEntity> getCommentEntitiesByParentCommentIdIsNullAndMerchId(String merchId);

    List<CommentEntity> getCommentEntitiesByParentCommentId(String commentId);

    List<CommentEntity> getCommentEntitiesByParentCommentIdNotNull();

    List<CommentEntity> getCommentEntitiesByMerchId(String merchId);


}
