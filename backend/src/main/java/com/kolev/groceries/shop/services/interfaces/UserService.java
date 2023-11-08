package com.kolev.groceries.shop.services.interfaces;

import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.models.User;
import com.kolev.groceries.shop.utils.requests.user.AddToBasketRequest;
import com.kolev.groceries.shop.utils.requests.user.UserLoginRequest;
import com.kolev.groceries.shop.utils.requests.user.UserRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserByUsername(String username);
    boolean userExists(String username);
    User registerUser(UserRegisterRequest request);
    User loginUser(UserLoginRequest request);
}
