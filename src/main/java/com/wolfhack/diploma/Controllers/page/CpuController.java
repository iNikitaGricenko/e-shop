package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.service.CpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accessories/cpu")
public class CpuController {

    private final CpuService cpuService;

    @GetMapping
    public String getPageCPU(Model model, Pageable pageable,
                             @RequestParam(value = "code", required = false) String productCode){
        model.addAttribute("title", "CPU products")
                .addAttribute("filterURL", "blocks/filters/cpu")
                .addAttribute("filter", "cpu")
                .addAttribute("products", cpuService.findAllFilteredByCode(pageable, productCode));

        return "products/product-list";
    }

    @GetMapping("/{model}/{product}")
    public String getPageProducts(@PathVariable(value = "product") String productName,
                                  @PathVariable(value = "model") String productModel, Model model) {
        Cpu cpu = cpuService.findByNameAndModel(productName, productModel);
        model.addAttribute("title", "Процессор " + productName)
                .addAttribute("product", cpu);

        return "products/detailed-cpu";
    }

    @PostMapping
    public String addCPU(
            @ModelAttribute("Laptop") Cpu cpu,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (cpuService.exists(cpu)) {
            return "redirect:/admin/setup?error=cpu=exists";
        }
        cpuService.save(cpu, new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});

        return "redirect:/accessories/cpu";
    }
}
