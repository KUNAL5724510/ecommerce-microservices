package com.ecommerce.categoryservice.Service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.categoryservice.Entity.Category;
import com.ecommerce.categoryservice.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{


    @Autowired
    private CategoryRepository categoryRepository;
    
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id) {
        
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null); // return null if not found 

    }   


    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}