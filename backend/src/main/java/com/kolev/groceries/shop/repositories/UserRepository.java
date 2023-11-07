package com.kolev.groceries.shop.repositories;

import com.kolev.groceries.shop.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    <S extends User> S save(S entity);
    Optional<User> findByUsername(String username);
}
