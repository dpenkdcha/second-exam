package com.spring.test.service.serviceImpl;

import com.spring.test.domains.OrdersEntity;
import com.spring.test.domains.ProductEntity;
import com.spring.test.dtos.request.OrderInputRequestDto;
import com.spring.test.dtos.request.Orders;
import com.spring.test.dtos.response.GetAllOrderResponse;
import com.spring.test.dtos.response.OrderResponse;
import com.spring.test.repository.OrdersRepository;
import com.spring.test.repository.ProductRepository;
import com.spring.test.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

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

    @Override
    public GetAllOrderResponse getOrderDetails() {

        List<OrdersEntity> ordersEntityList = ordersRepository.findAll();

        List<String> productIdList = new ArrayList<>();
                ordersEntityList.forEach(
                ordersEntity -> {
                    productIdList.add(ordersEntity.getProductId());
                }
        );

        List<ProductEntity> productEntities = productRepository.findByProductIdIn(productIdList);

        List<OrderResponse> orderResponseList = ordersEntityList.stream()
                .map(order -> {
                    return new OrderResponse(order.getOrderId(),
                            order.getPurchaseOrderNumber(), order.getShipDate(),
                            order.getProductId(), "", order.getRequestId(), order.getCreatedAt());
                }).collect(Collectors.toList());

        return new GetAllOrderResponse(orderResponseList);


    }


    @Override
    public GetAllOrderResponse getOrderById(String orderId) {


        return null;
    }


}
