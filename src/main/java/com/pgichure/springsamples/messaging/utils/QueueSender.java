package com.pgichure.springsamples.messaging.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pgichure.springsamples.messaging.models.Order;

@Component
public class QueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Order order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
