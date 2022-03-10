package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/periphery")
public class PeripheryController {

    @GetMapping
    public String getPage(Model model, Principal principal) {
        model.addAttribute("title", "Periphery");
        return "products/periphery";
    }

    @GetMapping("/mouses")
    public String getPageMouses(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/keyboards")
    public String getPageKeyboards(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/headphones")
    public String getPageHeadphones(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/acoustic-systems")
    public String getPageAcousticSystems(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/mouses-carpet")
    public String getPageMousesCarpet(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/microphones")
    public String getPageMicrophones(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/manipulators")
    public String getPageManipulators(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/periphery-kits")
    public String getPagePeripheryKits(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/webcams")
    public String getPageWebcams(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/brackets")
    public String getPageBrackets(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/tools")
    public String getPageTools(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }
    @GetMapping("/cleanings")
    public String getPageCleanings(Model model, Principal principal)
    {
        model.addAttribute("title", "Periphery");
        return "";
    }

}
