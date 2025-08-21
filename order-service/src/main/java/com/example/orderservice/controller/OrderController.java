package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/ordertest")
public class OrderController {
    private final WebClient webClient;

    @Autowired
    public OrderController(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://customer-service:8081").build();
    }

    @GetMapping
    public String getOrders(){
        return "Hi from Order Service";
    }

    @GetMapping("orders/customer-call")
    public String callCustomer(){
        return webClient.get().uri("/api/test").retrieve().bodyToMono(String.class).block();
    }
}
