package com.example.commentapi.service.message;

import com.example.commentapi.model.CommentDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SendServiceImpl implements SendService{
    private KafkaTemplate<Long, CommentDTO> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public SendServiceImpl(KafkaTemplate<Long, CommentDTO> kafkaTemplate,
                           ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    public SendServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }



    @Override
    public CommentDTO send(CommentDTO commentDTO) {
        log.info("<= sending {}", writeValueAsString(commentDTO));
        kafkaTemplate.send("comment-topic",commentDTO);
        return null;
    }
    private String writeValueAsString(CommentDTO commentDTO) {
        try {
            return objectMapper.writeValueAsString(commentDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + commentDTO.toString());
        }
    }
}
