package com.ecommerce.userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.userservice.Entity.User;
import com.ecommerce.userservice.Service.UserService;
import com.ecommerce.userservice.Util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Create new user
    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }

    // Get user by mobile
    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<?> getUserByMobile(@PathVariable String mobile) {
        User user = userService.getUserByMobile(mobile);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = userService.getUserByEmail(user.getEmail());

        if (existingUser != null) {
            if (existingUser.getPassword().equals(user.getPassword())) {
                String token = jwtUtil.generateToken(existingUser.getEmail(), existingUser.getRole());
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Password");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
}
