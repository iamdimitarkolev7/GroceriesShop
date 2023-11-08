package com.kolev.groceries.shop.utils.requests.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kolev.groceries.shop.enums.Deal;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddToBasketRequest {

    private String userId;
    private String productName;

    private Double productPrice;

    private Deal productDeal;
}
