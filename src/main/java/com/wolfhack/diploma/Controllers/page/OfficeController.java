package com.wolfhack.diploma.Controllers.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@RequiredArgsConstructor
@Controller
@RequestMapping("/office")
public class OfficeController {

    @GetMapping
    public String getPage(Model model, Principal principal) {
        model.addAttribute("title", "Office equipment");
        return "products/office-catalog";
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
