package com.spring.test.dtos.request;

import com.spring.test.annotation.DateUTCValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Orders {

    @NotBlank(message = "This field is mandatory and the format must be char[6]")
    @Size(min = 6, max = 6, message = "This field is mandatory and the format must be char[6]")
    private String orderId;

    @NotBlank(message = "This field is mandatory and the format must be char[8]")
    @Size(min = 8, max = 8, message = "This field is mandatory and the format must be char[8]")
    private String purchaseOrderNumber;

    @DateUTCValidation
    private String shipDate;

    @NotBlank(message = "This field is mandatory and the format must be char[3]")
    @Size(min = 3, max = 3, message = "This field is mandatory and the format must be char[3]")
    private String productId;

}
