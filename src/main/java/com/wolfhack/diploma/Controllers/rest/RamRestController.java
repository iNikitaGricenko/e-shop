package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Ram;
import com.wolfhack.diploma.service.RamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ram")
@RequiredArgsConstructor
public class RamRestController {

    private final RamService ramService;

    @GetMapping("/{id}")
    public Ram getRamById(@PathVariable("id") String id) {
        return ramService.findById(id);
    }

    @GetMapping
    public Page<Ram> getRams(Pageable pageable) {
        return ramService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRam(@RequestBody Ram ram) {
        ramService.save(ram);
    }

}
