package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Ssd;
import com.wolfhack.diploma.service.SsdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ssd")
@RequiredArgsConstructor
public class SsdRestController {

    private final SsdService ssdService;

    @GetMapping("/{id}")
    public Ssd getSsdById(@PathVariable("id") String id) {
        return ssdService.findById(id);
    }

    @GetMapping
    public Page<Ssd> getSsds(Pageable pageable) {
        return ssdService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSsd(Ssd ssd) {
        ssdService.save(ssd);
    }
}
