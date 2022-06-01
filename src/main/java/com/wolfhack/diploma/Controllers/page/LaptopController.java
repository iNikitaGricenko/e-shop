package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.service.LaptopService;
import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/laptop")
public class LaptopController {

    private final LaptopService laptopService;

    @GetMapping
    public String getPageLaptopProducts(@RequestParam(name= "maxCost", required = false, defaultValue = "0") double maxCost, Model model) {
        List<Laptop> laptops = laptopService.filterByMaxCost(maxCost);
        model.addAttribute("title", "Ноутбуки")
                .addAttribute("filterURL", "blocks/filters/laptop")
                .addAttribute("filter", "laptop")
                .addAttribute("products", laptops);

        return "products/product-list";
    }

    @GetMapping("/{product}-{model}")
    public String getPageProducts(@PathVariable(value = "product") String productName,
                                  @PathVariable(value = "model") String productModel, Model model) {
        Laptop product = laptopService.findByNameAndModel(productName, productModel);
        model.addAttribute("title", "Ноутбук " + productName)
                .addAttribute("product", product);
        return "products/detailed-products";
    }

    @PostMapping
    public String addLaptop(@ModelAttribute("Laptop") Laptop laptop,
                            @RequestParam("photo1") MultipartFile photo1, @RequestParam("photo2") MultipartFile photo2,
                            @RequestParam("photo3") MultipartFile photo3, @RequestParam("photo4") MultipartFile photo4,
                            @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (laptopService.exists(laptop)) {
            return "redirect:/admin/setup?error=laptop=exists";
        }
        laptopService.save(laptop, new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});
        return "redirect:/admin/setup";
    }
}
