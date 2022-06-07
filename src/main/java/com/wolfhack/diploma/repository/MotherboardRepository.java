package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Motherboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends MongoRepository<Motherboard, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Motherboard findByNameIsLikeAndModelIsLike(String name, String model);

}
