package com.kolev.groceries.shop.repositories;

import com.kolev.groceries.shop.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    <S extends Product> S save(S entity);
    boolean existsByName(String name);
    List<Product> findAll();
    void deleteByName(String name);
}
