package com.example.commentapi.service;

import com.example.commentapi.model.CommentDTO;
import com.example.commentapi.model.CommentRequest;
import com.example.commentapi.model.CommentResponse;
import com.example.commentapi.repository.CommentEntity;
import com.example.commentapi.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements  CommentService{
    @Autowired
    CommentRepository commentRepository;
    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    @Override
    public CommentResponse createComment(CommentRequest commentRequest) {
        commentRequest.setCommentId(UUID.randomUUID().toString());
        CommentEntity commentEntity=modelMapper.map(commentRequest,CommentEntity.class);
        commentRepository.save(commentEntity);
        return modelMapper.map(commentEntity,CommentResponse.class);
    }

    @Override
    public CommentResponse updateComment(CommentRequest commentRequest) {
        CommentEntity commentEntity=modelMapper.map(commentRequest,CommentEntity.class);
        CommentEntity dbEntity=commentRepository.getCommentEntitiesByCommentId(commentEntity.getCommentId());
        commentEntity.setCommentId(dbEntity.getCommentId());
        commentEntity=commentRepository.save(commentEntity);

        return modelMapper.map(commentEntity,CommentResponse.class) ;
    }

    @Override
    public CommentResponse getCommentById(String commentId) {
        CommentEntity commentEntity=commentRepository.getCommentEntitiesByCommentId(commentId);
        return modelMapper.map(commentEntity,CommentResponse.class);
    }

    @Override
    public List<CommentResponse> getAllComments() {
        return commentRepository.getCommentEntitiesBy().stream().map(commentEntity ->
                modelMapper.map(commentEntity,CommentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deletePaymentById(String commentId) {
    commentRepository.deleteCommentEntitiesByCommentId(commentId);

    }

    @Override
    public List<CommentResponse> getCommentEntitiesByParentCommentIdIsNullAndAndEMerchId(String merchId) {
        return commentRepository.getCommentEntitiesByParentCommentIdIsNullAndMerchId(merchId).stream()
                .map(comment -> modelMapper.map(comment, CommentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getAllRepliesOfComment(String commentId) {
          return commentRepository.getCommentEntitiesByParentCommentId(commentId).stream()
                .map(comment -> modelMapper.map(comment, CommentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getListOfReplyComments() {
        return commentRepository.getCommentEntitiesByParentCommentIdNotNull().stream()
                .map(comment -> modelMapper.map(comment, CommentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getCommentsByMerchId(String merchId) {
        return commentRepository.getCommentEntitiesByMerchId(merchId).stream()
                .map(comment -> modelMapper.map(comment, CommentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO sendMail(String commentId) {
        CommentDTO commentDTO=new CommentDTO();
        CommentResponse commentResponse=getCommentById(commentId);
        commentDTO.setMerchId(commentResponse.getMerchId());
        commentDTO.setText(commentResponse.getText());
        commentDTO.setText(commentResponse.getUserId());

        return commentDTO;
    }


}
