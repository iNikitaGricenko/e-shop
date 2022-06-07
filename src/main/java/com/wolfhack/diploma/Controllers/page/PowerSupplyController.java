package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.service.PowerSupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accessories/power-supply")
@RequiredArgsConstructor
public class PowerSupplyController {

    private final PowerSupplyService powerSupplyService;

    @GetMapping
    public String getPagePowerSupply(Model model, Pageable pageable) {
        model.addAttribute("title", "Motherboard products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd")
                .addAttribute("products", powerSupplyService.findAll(pageable));

        return "products/product-list";
    }

}
