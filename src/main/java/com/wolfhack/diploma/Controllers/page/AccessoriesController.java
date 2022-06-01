package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.models.products.Gpu;
import com.wolfhack.diploma.models.products.Ram;
import com.wolfhack.diploma.models.products.Ssd;
import com.wolfhack.diploma.service.CpuService;
import com.wolfhack.diploma.service.GpuService;
import com.wolfhack.diploma.service.RamService;
import com.wolfhack.diploma.service.SsdService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accessories")
public class AccessoriesController {


    private final RamService ramService;
    private final SsdService ssdService;
    private final CpuService cpuService;
    private final GpuService gpuService;

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

    @GetMapping("/ssd")
    public String getPageSSD(Model model, Pageable pageable) {
        model.addAttribute("title", "Ssd products")
                .addAttribute("filterURL", "blocks/filters/ssd")
                .addAttribute("filter", "ssd")
                .addAttribute("products", ssdService.findAll(pageable));
        return "products/product-list";
    }

    @GetMapping("/ram")
    public String getPageRAM(Model model, Pageable pageable) {
        model.addAttribute("title", "Ram products")
                .addAttribute("filterURL", "blocks/filters/ram")
                .addAttribute("filter", "ram")
                .addAttribute("products", ramService.findAll(pageable));
        return "products/product-list";
    }

    @GetMapping("/cpu")
    public String getPageCPU(Model model, Pageable pageable) {
        model.addAttribute("title", "CPU products")
                .addAttribute("filterURL", "blocks/filters/cpu")
                .addAttribute("filter", "cpu")
                .addAttribute("products", cpuService.findAll(pageable)); // @TODO change to service

        return "products/product-list";
    }

    @GetMapping("/gpu")
    public String getPageGPU(Model model, Pageable pageable) {
        model.addAttribute("title", "Ram products")
                .addAttribute("products", gpuService.findAll(pageable));

        return "products/accry/gpu";
    }

    @GetMapping("/motherboard")
    public String getPageMotherboard(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/motherboard";
    }

    @GetMapping("/case")
    public String getPageCase(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/case";
    }

    @GetMapping("/power-supply")
    public String getPagePowerSupply(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/power-supply";
    }

    @GetMapping("/cooling-system")
    public String getPageCoolingSystem(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/cooling-system";
    }

    @GetMapping("/sound-cards")
    public String getPageSoundCards(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/sound-card";
    }

    @GetMapping("/controllers-adapters")
    public String getPageControllersAdapters(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/controllers-adapters";
    }

    @GetMapping("/external-hdd")
    public String getPageExternalHDD(Model model, Principal principal) {
        model.addAttribute("title", "Ram products");
        return "products/accessories/external-hdd";
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

    @PostMapping("/ssd")
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

    @PostMapping("/ram")
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

    @PostMapping("/cpu")
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

    @PostMapping("/gpu")
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
