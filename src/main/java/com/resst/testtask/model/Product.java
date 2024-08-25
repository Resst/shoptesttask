package com.resst.testtask.model;

import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @GeneratedValue
    @Id
    private Long productId;
    @Column(nullable = false)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    private String manufacturer;

    @Column(nullable = false)
    private BigDecimal price;

    private Integer quantity;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode properties;

    public enum ProductType{
        PC,
        LAPTOP,
        MONITOR,
        HARD_DRIVE
    }
}