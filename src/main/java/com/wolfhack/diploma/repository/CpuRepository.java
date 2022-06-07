package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Cpu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuRepository extends MongoRepository<Cpu, String> {

    public Page findAllByCompatibility(Pageable pageable, String compatibility);

    boolean existsProductByNameAndModel(String name, String model);
    Cpu findByNameIsLikeAndModelIsLike(String name, String model);

}
