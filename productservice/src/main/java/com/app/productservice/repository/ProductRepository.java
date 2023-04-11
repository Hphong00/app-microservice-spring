package com.app.productservice.repository;

import com.app.productservice.dto.ProductDTO;
import com.app.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findProductById(String id);
}
