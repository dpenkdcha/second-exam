package com.spring.test.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersEntity {

    private UUID requestId;

    @Id
    private String orderId;

    private String purchaseOrderNumber;

    private Date shipDate;

    private String productId;

    private LocalDateTime createdAt;


}
