package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Gpu;
import com.wolfhack.diploma.service.GpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gpu")
@RequiredArgsConstructor
public class GpuRestController {

    private final GpuService gpuService;

    @GetMapping("/{id}")
    public Gpu getGpuById(@PathVariable("id") String id) {
        return gpuService.findById(id);
    }

    @GetMapping
    public Page<Gpu> getGpus(Pageable pageable) {
        return gpuService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addGpu(@RequestBody Gpu gpu) {
        gpuService.save(gpu);
    }

}
