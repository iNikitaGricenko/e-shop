package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop, String> {

    List<Laptop> findLaptopsByCostLessThanEqual(double cost);

}
