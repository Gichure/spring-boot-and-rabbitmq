package com.pgichure.springsamples.messaging.utils;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.pgichure.springsamples.messaging.models.Order;

@lombok.extern.slf4j.Slf4j
@Component
public class QueueConsumer{
	

    @RabbitListener(queues = {"${queue.name}"})
    public String receive(@Payload Order order) {
    	log.info("Received " + order.toString());
       return "Order Details " + order.toString();
    }
}