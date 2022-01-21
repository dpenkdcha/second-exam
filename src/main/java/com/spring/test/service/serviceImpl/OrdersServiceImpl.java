package com.spring.test.service.serviceImpl;

import com.spring.test.domains.OrdersEntity;
import com.spring.test.dtos.request.OrderInputRequestDto;
import com.spring.test.dtos.request.Orders;
import com.spring.test.repository.OrdersRepository;
import com.spring.test.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        List<OrdersEntity> ordersEntityList = ordersList.stream()
                .map(order -> {
                    Date shipDate = null;
                    try {
                        shipDate = dateFormat.parse(order.getShipDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return new OrdersEntity(requestId, order.getOrderId(),
                        order.getPurchaseOrderNumber(), shipDate, order.getOrderId(), LocalDateTime.parse(createdAt.substring(0, createdAt.length()-2)));
                })
                        .collect(Collectors.toList());

        ordersRepository.saveAll(ordersEntityList);

    }
}
