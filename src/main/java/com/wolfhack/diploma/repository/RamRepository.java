package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Ram;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends MongoRepository<Ram, String> {
}
