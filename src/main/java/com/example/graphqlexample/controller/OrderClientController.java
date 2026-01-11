package com.example.graphqlexample.controller;

import com.example.graphqlexample.dto.CreateOrderRequestDto;
import com.example.graphqlexample.service.OrderClientService;
import com.example.grpcexample.proto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderClientController {

    private final OrderClientService orderClientService;

    public OrderClientController(OrderClientService orderClientService) {
        this.orderClientService = orderClientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable long id) {
        OrderResponse response = orderClientService.getOrderById(id);
        return ResponseEntity.ok(response.toString());
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequestDto request) {
        OrderResponse response = orderClientService.createOrder(request.getProduct(), request.getPrice());
        return ResponseEntity.ok(response.toString());
    }
}
