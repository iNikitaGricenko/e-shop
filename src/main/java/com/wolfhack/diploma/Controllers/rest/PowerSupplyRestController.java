package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.PowerSupply;
import com.wolfhack.diploma.service.PowerSupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/powersupply")
@RequiredArgsConstructor
public class PowerSupplyRestController {

    private final PowerSupplyService powerSupplyService;

    @GetMapping("/{id}")
    public PowerSupply getPowerSupplyById(@PathVariable("id") String id) {
        return powerSupplyService.findById(id);
    }

    @GetMapping
    public Page<PowerSupply> getPowerSupplys(Pageable pageable) {
        return powerSupplyService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addPowerSupply(PowerSupply powerSupply) {
        powerSupplyService.save(powerSupply);
    }

}
