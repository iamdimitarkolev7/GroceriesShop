package com.kolev.groceries.shop.utils.requests.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteProductRequest {
    private String productName;
}
