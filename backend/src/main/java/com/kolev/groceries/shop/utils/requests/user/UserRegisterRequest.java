package com.kolev.groceries.shop.utils.requests.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kolev.groceries.shop.enums.Role;
import com.kolev.groceries.shop.utils.requests.user.base.UserAuthRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterRequest extends UserAuthRequest {

    private String confirmPassword;
}
