package com.kolev.groceries.shop.controllers;

import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.services.interfaces.ProductService;
import com.kolev.groceries.shop.utils.requests.product.AddProductRequest;
import com.kolev.groceries.shop.utils.requests.product.DeleteProductRequest;
import com.kolev.groceries.shop.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products/getAll")
    public ResponseEntity<Response> getAllProducts()
    {
        try {
            List<Product> allProducts = productService.getAllProducts();

            return ResponseEntity.ok(
                    Response.builder()
                            .message("All products retrieved successfully!")
                            .data("products", allProducts)
                            .build()
            );
        }
        catch (RuntimeException err) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }

    @PostMapping("/api/products/addNewProduct")
    public ResponseEntity<Response> addNewProduct(@RequestBody AddProductRequest request) {

        try {

            Product product = productService.addNewProduct(request);

            return ResponseEntity.ok(
                    Response.builder()
                            .data("product", product)
                            .message("A new product is successfully added!")
                            .build()
            );
        }
        catch (RuntimeException err) {

            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }

    @DeleteMapping("/api/products/deleteProduct")
    public ResponseEntity<Response> deleteProduct(@RequestBody DeleteProductRequest request) {

        try {

            productService.deleteProduct(request);

            return ResponseEntity.ok(
                    Response.builder()
                            .message("The product is successfully deleted!")
                            .build()
            );
        }
        catch (RuntimeException err) {

            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }
}
