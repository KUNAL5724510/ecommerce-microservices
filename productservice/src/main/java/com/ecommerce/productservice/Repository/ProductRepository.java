package com.ecommerce.productservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.productservice.Entity.Product;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
        
    Product findByName(String name);
    Optional findById(Long id);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    Product findByStatus(String status);


}
