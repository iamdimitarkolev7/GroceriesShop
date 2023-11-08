package com.kolev.groceries.shop.services.implementations;

import com.kolev.groceries.shop.exceptions.user.UserDoesNotExistException;
import com.kolev.groceries.shop.models.Product;
import com.kolev.groceries.shop.models.User;
import com.kolev.groceries.shop.repositories.UserRepository;
import com.kolev.groceries.shop.services.interfaces.BasketService;
import com.kolev.groceries.shop.utils.requests.user.AddToBasketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
@Transactional
public class BasketServiceImpl implements BasketService {

    private final UserRepository userRepository;

    @Override
    public void addProductToBasket(AddToBasketRequest request) {

        Optional<User> oUser = userRepository.findById(request.getUserId());

        if (oUser.isEmpty()) {
            throw new UserDoesNotExistException("User does not exist!");
        }

        User user = oUser.get();

        Product product = Product.builder()
                .name(request.getProductName())
                .price(request.getProductPrice())
                .deal(request.getProductDeal())
                .build();

        List<Product> currentUserBasket = user.getBasket();
        currentUserBasket.add(product);
        user.setBasket(currentUserBasket);

        userRepository.save(user);
    }

    @Override
    public List<Product> getBasketProducts(String userId) {

        Optional<User> oUser = userRepository.findById(userId);

        if (oUser.isEmpty()) {
            throw new UserDoesNotExistException("User does not exist!");
        }

        User user = oUser.get();

        return user.getBasket();
    }

    @Override
    public void emptyBasket(String userId) {

        Optional<User> oUser = userRepository.findById(userId);

        if (oUser.isEmpty()) {
            throw new UserDoesNotExistException("User does not exist!");
        }

        User user = oUser.get();
        user.setBasket(new ArrayList<>());
        userRepository.save(user);
    }

    @Override
    public Double calculateResult(String userId) {

        Optional<User> oUser = userRepository.findById(userId);

        if (oUser.isEmpty()) {
            throw new UserDoesNotExistException("User does not exist!");
        }

        User user = oUser.get();
        List<Product> basketProducts = user.getBasket();

        return calculateResult(basketProducts);
    }

    private Double calculateResult(List<Product> basketProducts) {

        double result = 0.0;

        List<Product> twoForThreeDealsArray = new ArrayList<>();
        Map<String, Double> buyOneGetOneDealMap = new HashMap<>();

        for (Product product : basketProducts) {

            switch (product.getDeal()) {

                case TWO_FOR_THREE -> {

                    twoForThreeDealsArray.add(product);

                    if (twoForThreeDealsArray.size() == 3) {
                        twoForThreeDealsArray.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                        result += twoForThreeDealsArray.get(0).getPrice() + twoForThreeDealsArray.get(1).getPrice();
                        twoForThreeDealsArray.clear();
                    }
                }
                case BUY_ONE_GET_ONE_HALF_PRICE -> {

                    if (!buyOneGetOneDealMap.containsKey(product.getName())) {
                        buyOneGetOneDealMap.put(product.getName(), product.getPrice());
                        result += product.getPrice();
                    }
                    else {
                        result += 0.5 * product.getPrice();
                        buyOneGetOneDealMap.remove(product.getName());
                    }
                }
            }
        }

        result += twoForThreeDealsArray.stream().mapToDouble(Product::getPrice).reduce(0, Double::sum);

        return result;
    }
}
