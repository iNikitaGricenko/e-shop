package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/laptop")
@RequiredArgsConstructor
public class LaptopRestController {

    private final LaptopService laptopService;

    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable("id") String id) {
        return laptopService.findById(id);
    }

    @GetMapping
    public Page<Laptop> getLaptops(Pageable pageable) {
        return laptopService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addLaptop(Laptop laptop) {
        laptopService.save(laptop);
    }

}
