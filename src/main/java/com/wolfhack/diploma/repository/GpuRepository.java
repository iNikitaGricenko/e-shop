package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Gpu;
import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GpuRepository extends MongoRepository<Gpu, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Gpu findByNameIsLikeAndModelIsLike(String name, String model);

}
