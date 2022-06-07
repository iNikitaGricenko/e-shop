package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Motherboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends MongoRepository<Motherboard, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Motherboard findByNameIsLikeAndModelIsLike(String name, String model);
    Page<Motherboard> findAllBySocket(Pageable pageable, String socket);
    Page<Motherboard> findAllByMemoryType(Pageable pageable, String memoryType);

}
