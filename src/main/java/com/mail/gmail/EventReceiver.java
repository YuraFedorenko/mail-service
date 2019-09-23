package com.mail.gmail;

import com.mail.model.MailEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventReceiver {

    private final GmailService gmailService;

    @KafkaListener(topics = "${app.topic.mail}", groupId = "mail-service")
    public void listenKafka(@Payload MailEvent event) {
        log.info("received message='{}'", event);

        gmailService.sendEmail(event.getParticipants().iterator().next(),
                "translation is " + event.getMetadata().get("phrase"),
                "TRANSLATION");
    }

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void listenRabbit(String text){
        log.info("received message='{}'", text);

        gmailService.sendEmail("yurafedorenko721@gmail.com",
                "message from rabbit is  " + text,
                "RABBIT");
    }
}
