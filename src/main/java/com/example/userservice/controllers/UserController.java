package com.example.userservice.controllers;

import com.example.userservice.dtos.UserDto;
import com.example.userservice.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/")
    public void createUser(@RequestBody UserDto user) {
        userService.createUser(user);
    }

    @PostMapping("/login/")
    public void login(@RequestBody UserDto user) throws Exception {
        userService.login(user);
    }


//    @PostMapping("/logout/")
//    public void logout() {
//
//    }
}
