package com.spring.test.controller;


import com.spring.test.dtos.request.OrderInputRequestDto;
import com.spring.test.dtos.response.GetAllOrderResponse;
import com.spring.test.dtos.response.OrderPostResponse;
import com.spring.test.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.spring.test.config.Consts.ADD_ORDER_ENDPOINT;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping(value = ADD_ORDER_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderPostResponse addOrderDetails(
            @RequestHeader UUID requestId,
            @RequestHeader String createdAt,
            @Valid @RequestBody OrderInputRequestDto orderInputRequestDto) {

         ordersService.addOrderDetails(orderInputRequestDto, requestId, createdAt);

        return new OrderPostResponse(requestId, createdAt);
    }


    @GetMapping("/v1/orders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOrderDetails() {
        GetAllOrderResponse getAllOrderResponses = ordersService.getOrderDetails();
        return new ResponseEntity(getAllOrderResponses, HttpStatus.OK);
    }

    @GetMapping("/v1/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOrderById(@PathVariable String orderId) {
        GetAllOrderResponse getAllOrderResponses = ordersService.getOrderById(orderId);
        return new ResponseEntity(getAllOrderResponses, HttpStatus.OK);
    }


}
