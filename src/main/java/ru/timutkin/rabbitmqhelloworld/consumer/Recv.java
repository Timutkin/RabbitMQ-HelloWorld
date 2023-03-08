package ru.timutkin.rabbitmqhelloworld.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedDeque;


@RabbitListener(queues = "queue")
@Component
@Slf4j
public class Recv {

    ConcurrentLinkedDeque<String> messages = new ConcurrentLinkedDeque<>();

    @RabbitHandler
    public void receive(String in) {
        messages.add(in);
        log.debug(" [x] Received '" + in + "'");
    }

    public String getMessage(){
        if (messages.isEmpty()){
            return "Queue is empty";
        }
        else{
            return messages.pop();
        }
    }

}
