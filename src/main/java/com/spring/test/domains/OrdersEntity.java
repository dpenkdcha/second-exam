package com.spring.test.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
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

    private String shipDate;

    private String productId;

    private String createdAt;


}
