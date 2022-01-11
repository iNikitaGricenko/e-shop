package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.Classes.AuthorizedModel;
import com.wolfhack.diploma.Classes.FileUploadUtil;
import com.wolfhack.diploma.models.products.*;
import com.wolfhack.diploma.repository.products.*;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accry")
public class AccryController extends AuthorizedModel {

    private final UserRepository userRepository;

    private final SsdRepository ssdRepository;
    private final RamRepository ramRepository;
    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;

    private <P extends Product, R extends ProductRepo> boolean saveProduct(P product, R repository, MultipartFile[] files) throws IOException{
        if (repository.existsProductByNameAndModel(product.getName(), product.getModel())) {
            return false;
        }

        P savedProduct = (P) repository.save(product);
        String uploadDir = "photos/product-photos/"+savedProduct.getCatalog()+savedProduct.getName()+"_"+savedProduct.getId();

        FileUploadUtil.trySaveFile(uploadDir, savedProduct.getPhotoNames(), files);

        return true;
    }

    @GetMapping
    public String getPage(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Accessories");
        return "products/accry";
    }

    @GetMapping("/hdd")
    public String getPageHDD(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Hdd products")
                .addAttribute("filterURL", "blocks/filters/hdd")
                .addAttribute("filter", "hdd");
        return "products/laptop";
    }

    @PostMapping("/hdd")
    public String addHDD(
            //@ModelAttribute("Laptop") HDD hdd,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5
    ) throws IOException
    {

        return "products/laptop";
    }

    @GetMapping("/ssd")
    public String getPageSSD(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ssd products");
        return "products/accry/ssd";
    }

    @PostMapping("/ssd")
    public String addSSD(
            @ModelAttribute("Laptop") Ssd ssd,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5
    ) throws IOException
    {
        if (saveProduct(ssd, ssdRepository, new MultipartFile[]{photo1,photo2,photo3,photo4,photo5}) == false) {
            return "redirect:/admin/setup?error=ssd=exists";
        }

        return "products/accry/ssd";
    }

    @GetMapping("/ram")
    public String getPageRAM(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/ram";
    }

    @PostMapping("/ram")
    public String addRAM(
            @ModelAttribute("Laptop") Ram ram,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5
    ) throws IOException
    {

        if (saveProduct(ram, ramRepository, new MultipartFile[]{photo1,photo2,photo3,photo4,photo5}) == false) {
            return "redirect:/admin/setup?error=ram=exists";
        }

        return "products/accry/ram";
    }

    @GetMapping("/cpu")
    public String getPageCPU(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/cpu";
    }

    @PostMapping("/cpu")
    public String addCPU(
            @ModelAttribute("Laptop") Cpu cpu,
            @RequestParam("photo1") MultipartFile photo1,
            @RequestParam("photo2") MultipartFile photo2,
            @RequestParam("photo3") MultipartFile photo3,
            @RequestParam("photo4") MultipartFile photo4,
            @RequestParam("photo5") MultipartFile photo5
    ) throws IOException
    {

        if (saveProduct(cpu, cpuRepository, new MultipartFile[]{photo1,photo2,photo3,photo4,photo5}) == false) {
            return "redirect:/admin/setup?error=cpu=exists";
        }

        return "products/accry/cpu";
    }

    @GetMapping("/gpu")
    public String getPageGPU(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/gpu";
    }

    @PostMapping("/gpu")
    public String addGPU(@ModelAttribute("Laptop") Gpu gpu,
                         @RequestParam("photo1") MultipartFile photo1,
                         @RequestParam("photo2") MultipartFile photo2,
                         @RequestParam("photo3") MultipartFile photo3,
                         @RequestParam("photo4") MultipartFile photo4,
                         @RequestParam("photo5") MultipartFile photo5) throws IOException {
        if (saveProduct(gpu, gpuRepository, new MultipartFile[]{photo1,photo2,photo3,photo4,photo5}) == false) {
            return "redirect:/admin/setup?error=gpu=exists";
        }

        return "products/accry/gpu";
    }

    @GetMapping("/motherboard")
    public String getPageMotherboard(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/motherboard";
    }

    @GetMapping("/case")
    public String getPageCase(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/case";
    }

    @GetMapping("/power-supply")
    public String getPagePowerSupply(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/power-supply";
    }

    @GetMapping("/cooling-system")
    public String getPageCoolingSystem(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/cooling-system";
    }

    @GetMapping("/sound-cards")
    public String getPageSoundCards(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/sound-cards";
    }

    @GetMapping("/controllers-adapters")
    public String getPageControllersAdapters(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/controllers-adapters";
    }

    @GetMapping("/external-hdd")
    public String getPageExternalHDD(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Ram products");
        return "products/accry/external-hdd";
    }

}
