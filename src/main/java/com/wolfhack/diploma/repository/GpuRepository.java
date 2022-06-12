package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Gpu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends MongoRepository<Gpu, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Gpu findByNameIsLikeAndModelIsLike(String name, String model);

    Page<Gpu> findAllByGpuInterfaceIsLike(Pageable pageable, String s);
}
