package com.example.graphqlexample.service;

import com.example.grpcexample.proto.CreateOrderRequest;
import com.example.grpcexample.proto.GetOrderByIdRequest;
import com.example.grpcexample.proto.OrderResponse;
import com.example.grpcexample.proto.OrderServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderClientService {

    @GrpcClient("orderService")
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    public OrderResponse getOrderById(long id) {
        GetOrderByIdRequest request = GetOrderByIdRequest.newBuilder()
                .setId(id)
                .build();
        return orderServiceBlockingStub.getOrderById(request);
    }

    public OrderResponse createOrder(String product, double price) {
        CreateOrderRequest request = CreateOrderRequest.newBuilder()
                .setProduct(product)
                .setPrice(price)
                .build();
        return orderServiceBlockingStub.createOrder(request);
    }
}
