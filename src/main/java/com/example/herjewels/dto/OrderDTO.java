package com.example.herjewels.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    @NotNull
    private Integer orderId;

    @NotNull
    private String productName;

    @NotNull
    private float price;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer total;
}
