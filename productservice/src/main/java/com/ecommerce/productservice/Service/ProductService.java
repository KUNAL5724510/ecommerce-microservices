package com.ecommerce.productservice.Service;

import com.ecommerce.productservice.Entity.Product;

public interface ProductService {
      Product saveProduct(Product product);
      Product getProductById(Long id);
      Product getProductByName(String name);
      Product getProductByStatus(String status);
      Product getProductByPriceRange(Double minPrice, Double maxPrice);
}
