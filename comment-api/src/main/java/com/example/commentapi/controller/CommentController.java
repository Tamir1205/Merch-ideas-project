package com.example.commentapi.controller;

import com.example.commentapi.model.CommentDTO;
import com.example.commentapi.model.CommentRequest;
import com.example.commentapi.model.CommentResponse;
import com.example.commentapi.service.CommentService;
import com.example.commentapi.service.message.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private SendService sendService;

    @PostMapping
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest);
    }

    @PutMapping
    public CommentResponse updateComment(@RequestParam String commentId,
                                         @RequestBody CommentRequest commentRequest) {
        commentRequest.setCommentId(commentId);
        return commentService.updateComment(commentRequest);
    }

    @GetMapping("/all")
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }
    @GetMapping
    public CommentResponse getCommentById(@RequestParam String commentId){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/commentFull")
    public List<CommentResponse> getAllReplies(@RequestParam String commentId) {
        return commentService.getAllRepliesOfComment(commentId);
    }
    @GetMapping("/replies")
    public List<CommentResponse> getReplyComments() {
        return commentService.getListOfReplyComments();
    }
    @GetMapping("/event")
    public List<CommentResponse> getCommentsByEventIds(@RequestParam String eventId) {
        return commentService.getCommentsByMerchId(eventId);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam String commentId){
        commentService.deletePaymentById(commentId);
    }
    @PostMapping("/mail")
    public CommentDTO sendEmail(@RequestParam String commentId){
    CommentDTO commentDTO=commentService.sendMail(commentId);
    return sendService.send(commentDTO);
    }
}
