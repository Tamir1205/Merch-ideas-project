package com.example.notificationapi.service.consume;

import com.example.notificationapi.model.CommentDTO;
import com.example.notificationapi.model.MerchDTO;
import com.example.notificationapi.service.consume.ConsumeService;
import com.example.notificationapi.service.send.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    private SendService sendService;

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id1}", topics = "${spring.kafka.topic.merch}",
            containerFactory = "singleFactoryMerch")
    public void consumeMerchMessage(MerchDTO message) {
        log.info("Message with Merch: {} successfully consumed", message);
        sendService.sendMerch(message);
    }

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id2}", topics = "${spring.kafka.topic.comments}",
            containerFactory = "singleFactoryComment")
    public void consumeCommentMessage(CommentDTO message) {
        log.info("Message with Comment: {} successfully consumed", message);
        sendService.sendComment(message);
    }
}
