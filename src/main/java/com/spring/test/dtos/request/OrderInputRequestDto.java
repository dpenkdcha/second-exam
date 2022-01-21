package com.spring.test.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInputRequestDto {

    @Valid
    @JsonProperty("orders")
    private List<Orders> orders;
}
