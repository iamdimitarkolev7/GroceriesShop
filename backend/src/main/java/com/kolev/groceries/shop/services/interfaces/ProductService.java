package com.kolev.groceries.shop.services.interfaces;

import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.utils.requests.product.AddProductRequest;
import com.kolev.groceries.shop.utils.requests.product.DeleteProductRequest;

import java.util.List;

public interface ProductService {

    Product addNewProduct(AddProductRequest request);
    List<Product> getAllProducts();
    void deleteProduct(DeleteProductRequest request);
}
