package com.example.userservice.services;

import com.example.userservice.dtos.UserDto;
import com.example.userservice.models.Session;
import com.example.userservice.models.User;
import com.example.userservice.repositories.SessionRepository;
import com.example.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("UserService")
public class UserService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public UserService(UserRepository userRepository,
                       SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
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


    public void login(UserDto userDto) throws Exception {
        String userEmail = userDto.getEmail();
        String userPassWord = userDto.getPassword();

        Optional<User> userFromDb = userRepository.findByEmailAndPassword(userEmail, userPassWord);

//        valid user credentials
        if (userFromDb.isPresent()) {
            System.out.println("User successfully logged in.");
//            create a user session and return success
            Session newUserSession = new Session();
            newUserSession.setUser(userFromDb.get());
            newUserSession.setToken(UUID.randomUUID().toString());
            sessionRepository.save(newUserSession);

            return;
        }
//        invalid user credentials
        throw new Exception("The user with provided credentials does not exist.");
    }
}
