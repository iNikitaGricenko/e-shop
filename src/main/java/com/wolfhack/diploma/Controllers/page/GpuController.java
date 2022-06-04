package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Gpu;
import com.wolfhack.diploma.service.GpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accessories/gpu")
public class GpuController {

    private final GpuService gpuService;

    @GetMapping
    public String getPageGPU(Model model, Pageable pageable) {
        model.addAttribute("title", "GPU products")
                .addAttribute("products", gpuService.findAll(pageable))
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @PostMapping
    public String addGPU(@ModelAttribute("Laptop") Gpu gpu,
                         @RequestParam("photo1") MultipartFile photo1,
                         @RequestParam("photo2") MultipartFile photo2,
                         @RequestParam("photo3") MultipartFile photo3,
                         @RequestParam("photo4") MultipartFile photo4,
                         @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (gpuService.exists(gpu)) {
            return "redirect:/admin/setup?error=gpu=exists";
        }
        gpuService.save(gpu, new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});

        return "products/accessories/gpu";
    }

}
