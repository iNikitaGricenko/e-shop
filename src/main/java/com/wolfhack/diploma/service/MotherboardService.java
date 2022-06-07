package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Motherboard;
import com.wolfhack.diploma.repository.MotherboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MotherboardService {

    private final MotherboardRepository motherboardRepository;

    public Page<Motherboard> findAll(Pageable pageable) {
        return motherboardRepository.findAll(pageable);
    }

    public Motherboard findById(String id) {
        return motherboardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void save(Motherboard motherboard) {
        motherboardRepository.save(motherboard);
    }
}
