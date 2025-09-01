package com.ecommerce.userservice.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.userservice.Entity.User;
import com.ecommerce.userservice.Service.UserService;

import java.util.List;




@RestController
@RequestMapping("/users")
public class UserController {
       
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
       
        return userService.saveUser(user);
          
    }

    @GetMapping("/All")
    public List<User> getUserById() {
       
        return userService.getAllUsers();

    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/mobile/{mobile}")
    public User getUserByMobile(@PathVariable String mobile) {
        return userService.getUserByMobile(mobile);
    }

    

}
