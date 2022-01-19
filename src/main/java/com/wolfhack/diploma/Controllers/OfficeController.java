package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@RequiredArgsConstructor
@Controller
@RequestMapping("/office")
public class OfficeController {

    private final UserRepository userRepository;

    @ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

    @GetMapping
    public String getPage(Model model, Principal principal) {
        model.addAttribute("title", "Office equipment");
        return "products/office";
    }

    @GetMapping("/mfp")
    public String getPageMFP(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
    @GetMapping("/printers")
    public String getPagePrinters(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
    @GetMapping("/cartridges")
    public String getPageCartridges(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
    @GetMapping("/monitors")
    public String getPageMonitors(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
    @GetMapping("/gaming-chair")
    public String getPageGamingChair(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
    @GetMapping("/ups")
    public String getPageUPS(Model model, Principal principal)
    {
        model.addAttribute("title", "Office equipment");
        return "";
    }
}
