package com.resst.testtask.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.resst.testtask.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPatchDto {

    private String serialNumber;

    private String manufacturer;

    private BigDecimal price;
    private Product.ProductType type;
    private Integer quantity;
    private JsonNode properties;
}
