package com.wolfhack.diploma.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventLogsListener {

    @KafkaListener(topics = "registration", groupId = "registrationId")
    public void registrationLogging(String data) {
        Date now = new Date();
        System.out.println(now + " Registration: " + data);
    }

}
