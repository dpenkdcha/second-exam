package com.spring.test.service.serviceImpl;

import com.spring.test.domains.OrdersEntity;
import com.spring.test.dtos.request.OrderInputRequestDto;
import com.spring.test.dtos.request.Orders;
import com.spring.test.repository.OrdersRepository;
import com.spring.test.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public void addOrderDetails(OrderInputRequestDto orderInputRequestDto, UUID requestId, String createdAt) {

        List<Orders> ordersList =  orderInputRequestDto.getOrders();

        List<OrdersEntity> ordersEntityList = ordersList.stream()
                .map(order -> new OrdersEntity(requestId, order.getOrderId(),
                        order.getPurchaseOrderNumber(), order.getShipDate(), order.getOrderId(), createdAt))
                        .collect(Collectors.toList());

        ordersRepository.saveAll(ordersEntityList);

    }
}
