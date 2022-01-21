package com.spring.test.controller;


import com.spring.test.dtos.request.OrderInputRequestDto;
import com.spring.test.dtos.response.OrderPostResponse;
import com.spring.test.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static com.spring.test.config.Consts.ADD_ORDER_ENDPOINT;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping(value = ADD_ORDER_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addOrderDetails(
            @RequestHeader UUID requestId,
            @RequestHeader String createdAt,
            @RequestBody @Valid OrderInputRequestDto orderInputRequestDto) {

        ordersService.addOrderDetails(orderInputRequestDto);

        return new ResponseEntity(new OrderPostResponse(requestId, createdAt), HttpStatus.CREATED);
    }


}
