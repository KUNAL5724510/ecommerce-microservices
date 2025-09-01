package com.ecommerce.categoryservice.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.categoryservice.Entity.Category;
import com.ecommerce.categoryservice.Service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/new")
    public Category createCategory(@RequestBody Category category) {
       
        return categoryService.saveCategory(category);
          
    }
    
    @GetMapping("/All")
    public List<Category> getAllCategories() {
       
        return categoryService.getAllCategories();

    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/name")
    public Category getCategoryByName(@RequestParam String name) {
        return categoryService.getCategoryByName(name);
    }  
    
}
  