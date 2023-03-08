package ru.timutkin.rabbitmqhelloworld.config;



import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MessagingConfig {

    @Bean
    public Queue queue(){
        return new Queue("queue");
    }

}
