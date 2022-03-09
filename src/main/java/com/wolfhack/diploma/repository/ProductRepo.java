package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo<T extends Product> extends JpaRepository<T, Long> {

    ProductRepo findById(long id);

    boolean existsProductByNameAndModel(String name, String model);
    Laptop findByNameIsLikeAndModelIsLike(String name, String model);

    List<Laptop> findByNameIsLike(String name);

}
