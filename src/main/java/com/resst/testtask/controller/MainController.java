package com.resst.testtask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String getMain(){
        return """
                Welcome! Here's an instruction on how to use my API:
                
                Relative path: /api/product
                Methods:
                GET - list all products
                POST - add new product to list
                
                Relative path: /api/product/{id}
                GET - get product by $id
                PUT - fully update product by $id
                PATCH - partially update product by $id
                DELETE - delete product by $id
                
                Relative path: /api/product/type/{type-name}
                GET - get products with type $type-name (enum Type). $type-name should be uppercase with _ delimiters
                
                Relative path: /h2-console
                Connects you to h2 console
                
                enum Type has values: PC, LAPTOP, MONITOR, HARD_DRIVE
                
                JSON object for product has the following structure:
                {
                    "productId": Long,
                    "serialNumber": "String",
                    "manufacturer": String,
                    "price": BigDecimal,
                    "type": enum Type,
                    "quantity": Integer,
                    "properties": {
                        "property1-name": property1-value,
                        "property2-name": property2-value
                    }
                }
                
                price and serialNumber cannot be empty or null for /api/product POST and /api/product/{id} PUT methods.
                
                /api/product/{id} would not update empty values.
                
                
                To connect to H2 console use following information:
                Saved Settings: Generic H2 (Embedded)
                Setting Name: Generic H2 (Embedded)
                
                Driver Class: org.h2.Driver
                JDBC URL: jdbc:h2:mem:testdb
                User Name: sa
                Password:
                (password is not set)
                """.replaceAll(" {4}", "&emsp;").replaceAll("\n", "<br>");

    }

}
