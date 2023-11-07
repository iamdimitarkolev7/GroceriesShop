package com.kolev.groceries.shop.utils.requests.user.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAuthRequest {

    protected String username;
    protected String password;
}
