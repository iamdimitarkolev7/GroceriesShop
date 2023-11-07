package com.kolev.groceries.shop.models;

import com.kolev.groceries.shop.enums.Deal;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    private String productId;
    private String name;
    private String imageUrl;

    private Double price;

    private Deal deal;
}
