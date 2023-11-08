package com.kolev.groceries.shop.models;

import com.kolev.groceries.shop.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    private String userId;
    private String username;
    private String password;

    private Role role;

    private List<Product> basket;
}
