package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.models.products.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CpuRepository extends MongoRepository<Cpu, String> {

    Page<Cpu> findAllByCompatibility(Pageable pageable, String compatibility);

    boolean existsProductByNameAndModel(String name, String model);
    Cpu findByNameIsLikeAndModelIsLike(String name, String model);

    Page<Cpu> findAllBySocket(Pageable pageable, String socket);

}
