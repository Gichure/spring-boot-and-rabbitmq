package com.pgichure.springsamples.messaging.utils;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import lombok.Slf4j;

@Slf4j;
@Component
public class QueueConsumer{

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Order order) {
        log.info("Message " + order.toString());
    }
}