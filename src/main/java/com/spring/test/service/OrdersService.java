package com.spring.test.service;

import com.spring.test.dtos.request.OrderInputRequestDto;

import java.util.UUID;

public interface OrdersService {

    void addOrderDetails(OrderInputRequestDto orderInputRequestDto, UUID requestId, String createdAt);
}
