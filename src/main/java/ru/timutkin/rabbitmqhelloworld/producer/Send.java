package ru.timutkin.rabbitmqhelloworld.producer;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
@Slf4j
public class Send {

    RabbitTemplate template;

    Queue queue;

    public void sendMessage(String message){
        template.convertAndSend(queue.getName(), message);
        log.debug(" [x] Sent '" + message + "'");
    }

}
