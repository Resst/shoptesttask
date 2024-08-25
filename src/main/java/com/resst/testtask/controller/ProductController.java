package com.resst.testtask.controller;

import com.resst.testtask.dto.ProductCreateDto;
import com.resst.testtask.dto.ProductDto;
import com.resst.testtask.dto.ProductPatchDto;
import com.resst.testtask.dto.ProductUpdateDto;
import com.resst.testtask.exception.ItemNotFoundException;
import com.resst.testtask.model.Product;
import com.resst.testtask.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @Valid @RequestBody ProductUpdateDto productUpdateDto) {
        productService.updateProduct(id, productUpdateDto);
        return ResponseEntity.ok("Product updated successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchProductById(@PathVariable Long id, @Valid @RequestBody ProductPatchDto productPatchDto){
        productService.patchProduct(id, productPatchDto);
        return ResponseEntity.ok("Product patched successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductCreateDto productCreateDto){
        productService.createProduct(productCreateDto);
        return ResponseEntity.ok("Product created successfully");
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("/type/{type}")
    public ResponseEntity<List<ProductDto>> getAllProductsByType(@PathVariable Product.ProductType type){
        return ResponseEntity.ok(productService.getAllProductsByType(type));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ItemNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
