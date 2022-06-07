package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Motherboard;
import com.wolfhack.diploma.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motherboard")
@RequiredArgsConstructor
public class MotherboardRestController {

    private final MotherboardService motherboardService;

    @GetMapping("/{id}")
    public Motherboard getMotherboardById(@PathVariable("id") String id) {
        return motherboardService.findById(id);
    }

    @GetMapping
    public Page<Motherboard> getMotherboards(Pageable pageable) {
        return motherboardService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addMotherboard(Motherboard motherboard) {
        motherboardService.save(motherboard);
    }

}
