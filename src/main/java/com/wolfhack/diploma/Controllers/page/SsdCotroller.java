package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Ssd;
import com.wolfhack.diploma.service.SsdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accessories/ssd")
public class SsdCotroller {

    private final SsdService ssdService;

    @GetMapping
    public String getPageSSD(Model model, Pageable pageable) {
        model.addAttribute("title", "Ssd products")
                .addAttribute("filterURL", "blocks/filters/ssd")
                .addAttribute("filter", "ssd")
                .addAttribute("products", ssdService.findAll(pageable));

        return "products/product-list";
    }

    @PostMapping
    public String addSSD(
            @ModelAttribute("Laptop") Ssd ssd,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (ssdService.exists(ssd)) {
            return "redirect:/admin/setup?error=ssd=exists";
        }
        ssdService.save(ssd, new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});

        return "redirect:/accessories/ssd";
    }

}
