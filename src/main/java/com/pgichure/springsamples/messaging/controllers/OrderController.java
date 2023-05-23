package com.pgichure.springsamples.messaging.controllers;

@RestController
@RequestMapping("/orders")
@RequiredArgumentsConstructor
public class OrderController{

    private final QueueSender queueSender;

    @GetMapping
    public String send(Order order){
        queueSender.send(order);
        return "ok. done";
    }

}