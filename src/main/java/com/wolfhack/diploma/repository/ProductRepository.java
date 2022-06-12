package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Page<Product> findAllById(Pageable pageable, List<String> productIds);
}
