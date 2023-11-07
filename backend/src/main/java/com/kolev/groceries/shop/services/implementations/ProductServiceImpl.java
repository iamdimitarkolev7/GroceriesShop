package com.kolev.groceries.shop.services.implementations;

import com.kolev.groceries.shop.exceptions.product.ProductAlreadyExistsException;
import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.repositories.ProductRepository;
import com.kolev.groceries.shop.services.interfaces.ProductService;
import com.kolev.groceries.shop.utils.requests.product.AddProductRequest;
import com.kolev.groceries.shop.utils.requests.product.DeleteProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addNewProduct(AddProductRequest request) {

        if (productRepository.existsByName(request.getProductName())) {
            throw new ProductAlreadyExistsException("Product already exists!");
        }

        Product product =  Product.builder()
                .name(request.getProductName())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .deal(request.getDeal())
                .build();

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(DeleteProductRequest request) {
        productRepository.deleteByName(request.getProductName());
    }
}
