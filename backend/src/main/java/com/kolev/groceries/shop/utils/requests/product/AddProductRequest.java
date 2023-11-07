package com.kolev.groceries.shop.utils.requests.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kolev.groceries.shop.enums.Deal;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddProductRequest {

    private String productName;
    private String imageUrl;
    private Double price;
    private Deal deal;
}
