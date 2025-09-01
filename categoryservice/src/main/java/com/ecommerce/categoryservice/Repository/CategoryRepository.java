package com.ecommerce.categoryservice.Repository;

import java.util.function.LongPredicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.categoryservice.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
       Category findByName(String name);
       Category findByCategoryId(int categoryId);
}
