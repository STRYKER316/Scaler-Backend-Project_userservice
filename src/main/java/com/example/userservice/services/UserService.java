package com.example.userservice.services;

import com.example.userservice.dtos.UserDto;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDto userDto) {
//        System.out.println("User created with email: " + user.getEmail() + " and password: " + user.getPassword());

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
//        save to DB
        if (userRepository.save(newUser) == null) {
            System.out.println("Unable to save user");
        }
        System.out.println("User saved to DB");
    }
}
