package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.PowerSupply;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerSupplyRepository extends MongoRepository<PowerSupply, String> {
}
