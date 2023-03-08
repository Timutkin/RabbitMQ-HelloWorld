package ru.timutkin.rabbitmqhelloworld.web;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.timutkin.rabbitmqhelloworld.consumer.Recv;



@AllArgsConstructor
@RestController
@RequestMapping(
        value = "/recv",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RecvController {

    Recv recv;

    @GetMapping()
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(recv.getMessage());
    }



}
