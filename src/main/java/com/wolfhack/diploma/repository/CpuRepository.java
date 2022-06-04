package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Cpu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuRepository extends ProductRepository<Cpu> {

    public Page findAllByCompatibility(Pageable pageable, String compatibility);

}
