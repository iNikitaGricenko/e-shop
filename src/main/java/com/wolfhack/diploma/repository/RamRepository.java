package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Ram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends MongoRepository<Ram, String> {

    boolean existsProductByNameAndModel(String name, String model);
    Ram findByNameIsLikeAndModelIsLike(String name, String model);

    Page<Ram> findAllByType(Pageable pageable, String s);
}
