package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.service.CpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpu")
@RequiredArgsConstructor
public class CpuRestController {

    private final CpuService cpuService;

    @GetMapping("/{id}")
    public Cpu getCpuById(@PathVariable("id") String id) {
        return cpuService.findById(id);
    }

    @GetMapping
    public Page<Cpu> getCpus(Pageable pageable) {
        return cpuService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCpu(@RequestBody Cpu cpu) {
        cpuService.save(cpu);
    }

}
