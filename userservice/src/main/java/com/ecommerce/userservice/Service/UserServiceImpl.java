package com.ecommerce.userservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.userservice.Entity.User;
import com.ecommerce.userservice.Repository.UserRepository;

import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService{
    

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // return null if not found
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByMobile(String mobile) {
        return userRepository.findBymobile(mobile);
    }

}
