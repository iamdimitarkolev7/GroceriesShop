package com.kolev.groceries.shop.controllers;

import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.services.interfaces.BasketService;
import com.kolev.groceries.shop.utils.requests.user.AddToBasketRequest;
import com.kolev.groceries.shop.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/api/basket/addToBasket")
    public ResponseEntity<Response> addToBasket(@RequestBody AddToBasketRequest request) {

        try {
            basketService.addProductToBasket(request);

            return ResponseEntity.ok(
                    Response.builder()
                            .message("Product added successfully to the basket!")
                            .build()
            );
        }
        catch(RuntimeException err) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }

    @GetMapping("/api/basket/getBasketProducts/{id}")
    public ResponseEntity<Response> getBasketProducts(@PathVariable("id") String userId) {

        try {
            List<Product> basketProducts = basketService.getBasketProducts(userId);

            return ResponseEntity.ok(
                    Response.builder()
                            .message("Basket products retrieved successfully!")
                            .data("products", basketProducts)
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

    @GetMapping("/api/basket/emptyBasket/{id}")
    public ResponseEntity<Response> emptyBasket(@PathVariable("id") String userId) {

        try {
            basketService.emptyBasket(userId);

            return ResponseEntity.ok(
                    Response.builder()
                            .message("Basket is emptied successfully!")
                            .build()
            );
        }
        catch(RuntimeException err) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }

    @GetMapping("/api/basket/calculateBasketProducts/{id}")
    public ResponseEntity<Response> calculateBasketProducts(@PathVariable("id") String userId) {

        try {
            Double result = basketService.calculateResult(userId);

            return ResponseEntity.ok(
                    Response.builder()
                            .message("Result calculated successfully!")
                            .data("result", result)
                            .build()
            );
        }
        catch(RuntimeException err) {
            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }
}
