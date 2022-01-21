package com.spring.test.service;

import com.spring.test.dtos.request.OrderInputRequestDto;

public interface OrdersService {

    void addOrderDetails(OrderInputRequestDto orderInputRequestDto);
}
