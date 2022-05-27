package com.example.datastoreapi.service.message;

import com.example.datastoreapi.model.MerchDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendServiceImpl implements SendService{
    private KafkaTemplate<Long, MerchDTO> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Autowired
    public SendServiceImpl(KafkaTemplate<Long, MerchDTO> kafkaTemplate,
                           ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public SendServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public MerchDTO send(MerchDTO merchDTO) {
        log.info("<= sending {}", writeValueAsString(merchDTO));
        kafkaTemplate.send("merch-topic",merchDTO);
        return null;
    }
    private String writeValueAsString(MerchDTO merchDTO) {
        try {
            return objectMapper.writeValueAsString(merchDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + merchDTO.toString());
        }
    }
}
