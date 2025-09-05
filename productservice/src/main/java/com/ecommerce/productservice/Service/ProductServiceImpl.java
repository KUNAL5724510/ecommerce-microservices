package com.ecommerce.productservice.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productservice.Entity.Product;
import com.ecommerce.productservice.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService   {
     
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null); // return null if not found
    }
    
    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product getProductByStatus(String status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public Product getProductByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice).stream().findFirst().orElse(null);
    }
}
