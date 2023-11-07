package com.kolev.groceries.shop.controllers;

import com.kolev.groceries.shop.enums.Role;
import com.kolev.groceries.shop.models.User;
import com.kolev.groceries.shop.services.interfaces.UserService;
import com.kolev.groceries.shop.utils.requests.user.UserLoginRequest;
import com.kolev.groceries.shop.utils.requests.user.UserRegisterRequest;
import com.kolev.groceries.shop.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") String userId) {
        return null;
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserRegisterRequest request) {

        try {

            User user = userService.registerUser(request);

            return ResponseEntity.ok(
                    Response.builder()
                            .data("user", user)
                            .data("userRole", user.getRole())
                            .message("User registered successfully!")
                            .build()
            );
        }
        catch(RuntimeException err) {

            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }

    @PostMapping("/api/users/login")
    public ResponseEntity<Response> loginUser(@RequestBody UserLoginRequest request) {

        try {

            User user = userService.loginUser(request);

            return ResponseEntity.ok(
                    Response.builder()
                            .data("user", user)
                            .data("userRole", user.getRole())
                            .message("User logged in successfully!")
                            .build()
            );
        }
        catch(RuntimeException err) {

            return ResponseEntity.badRequest().body(
                    Response.builder()
                            .message(err.getMessage())
                            .build()
            );
        }
    }
}
