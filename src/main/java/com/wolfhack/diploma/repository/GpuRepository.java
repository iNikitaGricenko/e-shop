package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Gpu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends MongoRepository<Gpu, String> {
}
