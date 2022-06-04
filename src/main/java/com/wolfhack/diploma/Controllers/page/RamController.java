package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Ram;
import com.wolfhack.diploma.service.RamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accessories/ram")
public class RamController {

    private final RamService ramService;

    @GetMapping
    public String getPageRAM(Model model, Pageable pageable) {
        model.addAttribute("title", "Ram products")
                .addAttribute("filterURL", "blocks/filters/ram")
                .addAttribute("filter", "ram")
                .addAttribute("products", ramService.findAll(pageable));

        return "products/product-list";
    }

    @PostMapping
    public String addRAM(
            @ModelAttribute("Laptop") Ram ram,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (ramService.exists(ram)) {
            return "redirect:/admin/setup?error=ram=exists";
        }
        ramService.save(ram, new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});

        return "redirect:/accessories/ram";
    }

}
