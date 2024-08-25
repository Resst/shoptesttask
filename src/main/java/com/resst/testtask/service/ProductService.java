package com.resst.testtask.service;

import com.resst.testtask.dto.ProductCreateDto;
import com.resst.testtask.dto.ProductDto;
import com.resst.testtask.dto.ProductPatchDto;
import com.resst.testtask.dto.ProductUpdateDto;
import com.resst.testtask.exception.ItemNotFoundException;
import com.resst.testtask.model.Product;
import com.resst.testtask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        return mapProductToDto(product);
    }

    public void createProduct(ProductCreateDto productCreateDto) {
        Product product = Product.builder()
                .manufacturer(productCreateDto.getManufacturer())
                .price(productCreateDto.getPrice())
                .serialNumber(productCreateDto.getSerialNumber())
                .type(productCreateDto.getType())
                .quantity(productCreateDto.getQuantity())
                .properties(productCreateDto.getProperties())
                .build();
        productRepository.save(product);
    }

    public void updateProduct(Long id, ProductUpdateDto productUpdateDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

        product.setManufacturer(productUpdateDto.getManufacturer());
        product.setType(productUpdateDto.getType());
        product.setPrice(productUpdateDto.getPrice());
        product.setSerialNumber(productUpdateDto.getSerialNumber());
        product.setQuantity(productUpdateDto.getQuantity());
        product.setProperties(productUpdateDto.getProperties());

        productRepository.save(product);

    }

    public void patchProduct(Long id, ProductPatchDto productPatchDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

        if (productPatchDto.getSerialNumber() != null)
            product.setSerialNumber(productPatchDto.getSerialNumber());

        if (productPatchDto.getManufacturer() != null)
            product.setManufacturer(productPatchDto.getManufacturer());

        if (productPatchDto.getPrice() != null)
            product.setPrice(productPatchDto.getPrice());

        if (productPatchDto.getType() != null)
            product.setType(productPatchDto.getType());

        if (productPatchDto.getQuantity() != null)
            product.setQuantity(productPatchDto.getQuantity());

        if (productPatchDto.getProperties() != null)
            product.setProperties(productPatchDto.getProperties());

        productRepository.save(product);

    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id))
            productRepository.deleteById(id);
        else
            throw new ItemNotFoundException(id);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProductToDto).toList();
    }


    public List<ProductDto> getAllProductsByType(Product.ProductType type) {
        List<Product> products = productRepository.findAllByType(type);
        return products.stream().map(this::mapProductToDto).toList();
    }

    private ProductDto mapProductToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .manufacturer(product.getManufacturer())
                .serialNumber(product.getSerialNumber())
                .price(product.getPrice())
                .type(product.getType())
                .quantity(product.getQuantity())
                .properties(product.getProperties())
                .build();
    }
}
