package com.victor.auth_api.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.victor.auth_api.User.dto.LoginResponse;
import com.victor.auth_api.User.dto.RegisterResponse;
import com.victor.auth_api.User.dto.RegisterUserRequest;
import com.victor.auth_api.User.dto.LoginUserRequest;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/auth/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/api/auth/register")
    public RegisterResponse register(@Valid @RequestBody RegisterUserRequest request) {
        return userService.registerNewUsers(request);
    }

    @PostMapping("/api/auth/login")
    public LoginResponse Login(@Valid @RequestBody LoginUserRequest request) {
        return userService.loginUser(request);
    }
    
    
}
