package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository<T extends Product> extends MongoRepository<T, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Product findByNameIsLikeAndModelIsLike(String name, String model);

    List<Product> findByNameIsLike(String name);

}
