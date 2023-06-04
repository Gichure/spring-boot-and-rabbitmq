package com.pgichure.springsamples.messaging.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgichure.springsamples.messaging.models.Order;
import com.pgichure.springsamples.messaging.utils.QueueConsumer;
import com.pgichure.springsamples.messaging.utils.QueueSender;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Api(tags = {"Orders Management"}, description = "Operations on orders queue management")
public class OrderController{

    private final QueueSender queueSender;
    
    private final QueueConsumer queueConsumer;
    
    @GetMapping
    @ApiOperation(value = "Fetch queued Order", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the record"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The server encountered an error")
    })
    public String view(Order order){
    	return queueConsumer.receive(order);
    }
    
    @PostMapping
    @ApiOperation(value = "Queue an Order a product", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully queued the record"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The server encountered an error")
    })
    public String send(Order order){
        queueSender.send(order);
        return "ok. done";
    }

}