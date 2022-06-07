package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accessories/motherboard")
@RequiredArgsConstructor
public class MotherboardController {

    private final MotherboardService motherboardService;

    @GetMapping
    public String getPageMotherboard(Model model, Pageable pageable) {
        model.addAttribute("title", "Motherboard products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd")
                .addAttribute("products", motherboardService.findAll(pageable));

        return "products/product-list";
    }

}
