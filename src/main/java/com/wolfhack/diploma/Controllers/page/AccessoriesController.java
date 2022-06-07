package com.wolfhack.diploma.Controllers.page;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accessories")
public class AccessoriesController {

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("title", "Accessories");
        return "products/accessories-catalog";
    }

    @GetMapping("/hdd")
    public String getPageHDD(Model model) {
        model.addAttribute("title", "Hdd products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @GetMapping("/case")
    public String getPageCase(Model model, Pageable pageable) {
        model.addAttribute("title", "case products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @GetMapping("/cooling-system")
    public String getPageCoolingSystem(Model model, Pageable pageable) {
        model.addAttribute("title", "Cooling Systems")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @GetMapping("/sound-cards")
    public String getPageSoundCards(Model model, Pageable pageable) {
        model.addAttribute("title", "Sound Cards")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @GetMapping("/controllers-adapters")
    public String getPageControllersAdapters(Model model, Pageable pageable) {
        model.addAttribute("title", "Controllers & Adapters")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @GetMapping("/external-hdd")
    public String getPageExternalHDD(Model model, Pageable pageable) {
        model.addAttribute("title", "External HDD products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");

        return "products/product-list";
    }

    @PostMapping("/hdd")
    public String addHDD(
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5
    ) throws IOException
    {

        return "redirect:/accessories/hdd";
    }

}
