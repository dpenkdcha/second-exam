package com.spring.test.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Orders {

    @Size(min = 6, max = 6, message = "This field is mandatory and the format must be char[6]")
    private String orderId;

    @Size(min = 8, max = 8, message = "This field is mandatory and the format must be char[8]")
    private String purchaseOrderNumber;


    private String shipDate;

    @Size(min = 3, max = 3, message = "This field is mandatory and the format must be char[3]")
    private String productId;

}
