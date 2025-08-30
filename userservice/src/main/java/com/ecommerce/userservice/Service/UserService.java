package com.ecommerce.userservice.Service;

import java.util.List;

import com.ecommerce.userservice.Entity.User;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByMobile(String mobile);
    List<User> getAllUsers();


}
