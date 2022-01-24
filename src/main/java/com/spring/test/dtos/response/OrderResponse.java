package com.spring.test.dtos.response;

import com.spring.test.annotation.DateUTCValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private String orderId;

    private String purchaseOrderNumber;

    private Date shipDate;

    private String productId;

    private String productName;

    private UUID requestId;

    private LocalDateTime createdAt;

}
