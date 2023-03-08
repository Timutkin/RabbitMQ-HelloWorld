package ru.timutkin.rabbitmqhelloworld.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.timutkin.rabbitmqhelloworld.producer.Send;


@AllArgsConstructor
@RestController
@RequestMapping(
        value = "/send",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SendController {

    Send send;

    @PostMapping()
    public ResponseEntity<String> sendMessage(@RequestParam(name = "message") String message){
        send.sendMessage(message);
        return ResponseEntity.ok("The message has been sent successfully");
    }
}
