package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.service.FileUploadUtil;
import com.wolfhack.diploma.models.products.Laptop;
import com.wolfhack.diploma.repository.LaptopRepository;
import com.wolfhack.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class LaptopController {

    private final UserRepository userRepository;
    private final LaptopRepository laptopRepository;

    @ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

    @GetMapping("/laptop")
    public String getPageLaptopProducts(@RequestParam(name="maxcost", required = false, defaultValue = "0") double maxcost,
                                        Model model, Principal principal) {
        model.addAttribute("title", "Ноутбуки")
                .addAttribute("filterURL", "blocks/filters/laptop")
                .addAttribute("filter", "laptop");

        List<Laptop> laptops;

        if (maxcost != 0) {
            laptops = laptopRepository.findLaptopsByCostLessThanEqual(maxcost);
        } else {
            laptops = laptopRepository.findAll();
        }

        model.addAttribute("products", laptops);

        return "products/laptop";
    }

    @GetMapping("/{product}={model}")
    public String getPageProducts(@PathVariable(value = "product") String productName,
                                  @PathVariable(value = "model") String productModel,
                                  Model model, Principal principal) {
        model.addAttribute("title", "Product");

        Laptop product = laptopRepository.findByNameIsLikeAndModelIsLike(productName.replace("-", " "), productModel);

        model.addAttribute("product", product);

        return "products/detailed-products";
    }

    @PostMapping("/laptop")
    public String addLaptop(@ModelAttribute("Laptop") Laptop laptop,
                            @RequestParam("photo1") MultipartFile photo1, @RequestParam("photo2") MultipartFile photo2,
                            @RequestParam("photo3") MultipartFile photo3, @RequestParam("photo4") MultipartFile photo4,
                            @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (laptopRepository.existsProductByNameAndModel(laptop.getName(), laptop.getModel())) {
            return "redirect:/admin/setup?error=laptop=exists";
        }

        Laptop savedLaptop = laptopRepository.save(laptop);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), new MultipartFile[]{photo1, photo2, photo3, photo4, photo5});

        return "redirect:/admin/setup";
    }
}
