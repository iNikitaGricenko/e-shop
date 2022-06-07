package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Motherboard;
import com.wolfhack.diploma.service.MotherboardService;
import com.wolfhack.diploma.service.PCConstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/accessories/motherboard")
@RequiredArgsConstructor
public class MotherboardController {

    private final MotherboardService motherboardService;
    private final PCConstructorService constructorService;

    @GetMapping
    public String getPageMotherboard(@RequestParam(required = false, name = "cpu", defaultValue = "") String cpuCode,
                                     @RequestParam(required = false, name = "ram", defaultValue = "") String ramCode,
                                     Model model, Pageable pageable) {
        System.out.println("ram"+ramCode);
        HashMap<String, String> productsCode = new HashMap<>();
        productsCode.put("cpu", cpuCode);
        productsCode.put("ram", ramCode);
        Page<Motherboard> motherboards = constructorService.findMotherboardByCpuAndRamCompatible(pageable, productsCode);
        model.addAttribute("title", "Motherboard products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd")
                .addAttribute("products", motherboards);

        return "products/product-list";
    }

}
