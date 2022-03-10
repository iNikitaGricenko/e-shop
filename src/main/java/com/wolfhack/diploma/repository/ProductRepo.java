package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepo<T extends Product> extends MongoRepository<T, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Laptop findByNameIsLikeAndModelIsLike(String name, String model);

    List<Laptop> findByNameIsLike(String name);

}
