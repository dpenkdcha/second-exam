package com.spring.test.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderPostResponse {

    private UUID requestId;

    private String createAt;

}
