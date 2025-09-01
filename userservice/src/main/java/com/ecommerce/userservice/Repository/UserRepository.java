package com.ecommerce.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.userservice.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
     
       User findByEmail(String email);
       User findBymobile(String mobile);

}
