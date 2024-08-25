package com.resst.testtask.repository;

import com.resst.testtask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByType(Product.ProductType type);


}
