package com.ecommerce.productservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.Entity.Product;
import com.ecommerce.productservice.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/new")
    public Product createProduct(@RequestBody Product product) {
       
        return productService.saveProduct(product);
          
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/status/{status}")
    public Product getProductByStatus(@PathVariable String status) {
        return productService.getProductByStatus(status);
    }

    @GetMapping("/price-range")
    public Product getProductByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return productService.getProductByPriceRange(minPrice, maxPrice);
    }
}
