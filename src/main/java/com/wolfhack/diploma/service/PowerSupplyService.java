package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.PowerSupply;
import com.wolfhack.diploma.repository.PowerSupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;


    public Page<PowerSupply> findAll(Pageable pageable) {
        return powerSupplyRepository.findAll(pageable);
    }

    public PowerSupply findById(String id) {
        return powerSupplyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void save(PowerSupply powerSupply) {
        powerSupplyRepository.save(powerSupply);
    }
}
