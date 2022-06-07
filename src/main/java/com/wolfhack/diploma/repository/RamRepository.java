package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Ram;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends MongoRepository<Ram> {
}
