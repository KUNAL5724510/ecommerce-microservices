package com.ecommerce.categoryservice.Service;

import java.util.List;

import com.ecommerce.categoryservice.Entity.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(int id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
}
