package com.kolev.groceries.shop.services.interfaces;

import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.utils.requests.user.AddToBasketRequest;

import java.util.List;

public interface BasketService {
    void addProductToBasket(AddToBasketRequest request);
    List<Product> getBasketProducts(String userId);
    void emptyBasket(String userId);
    Double calculateResult(String userId);
}
