package com.resst.testtask.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.resst.testtask.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreateDto {

    @NotBlank(message = "serialNumber is mandatory")
    private String serialNumber;

    private String manufacturer;

    @NotNull(message = "price is mandatory")
    private BigDecimal price;
    private Product.ProductType type;
    private Integer quantity;
    private JsonNode properties;
}
