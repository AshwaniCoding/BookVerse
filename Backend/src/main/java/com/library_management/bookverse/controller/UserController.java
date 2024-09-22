package com.library_management.bookverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library_management.bookverse.model.User;
import com.library_management.bookverse.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> get() {
        return userService.get();
    }

    @PostMapping("/user")
    public User save(@RequestBody User userObj) {
        userService.save(userObj);
        return userObj;
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable("id") int user_id) {
        User userObj = userService.get(user_id);
        if (userObj == null) {
            throw new RuntimeException("User with id " + user_id + " is not found.");
        }
        return userObj;
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int user_id) {
        userService.delete(user_id);
        return "User has been deleted with id " + user_id;
    }

    @PutMapping("/user")
    public User update(@RequestBody User userObj) {
        userService.save(userObj);
        return userObj;
    }
    
    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        User existingUser = userService.login(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            throw new RuntimeException("Invalid email or password.");
        }
        return existingUser;
    }

    @PostMapping("/user/signup")
    public User signup(@RequestBody User user) {
        // Check if user already exists
        User existingUser = userService.getByEmail(user.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User with this email already exists.");
        }
        userService.save(user);
        return user;
    }

    @PostMapping("/user/reset-password")
    public String resetPassword(@RequestBody String email) {
        boolean result = userService.resetPassword(email);
        if (result) {
            return "Password reset link sent to " + email;
        } else {
            throw new RuntimeException("Email not found.");
        }
    }

}
