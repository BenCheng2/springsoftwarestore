package store.softstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.softstore.model.User;
import store.softstore.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        System.out.println("Hi");
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Login successful\n");
        return "login";
    }
}
