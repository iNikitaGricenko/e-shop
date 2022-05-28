package com.wolfhack.diploma.Controllers.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class MainController {

    @GetMapping("/about")
    public String getPageIndex(Model model, Principal principal) {
        model.addAttribute("title", "Home page");
        return "index";
    }

    @GetMapping("/example")
    public String getPageExample(Model model, Principal principal) {
        model.addAttribute("title", "Home page");
        return "products/detailed-example";
    }

    @GetMapping
    public String getPageHome(Model model, Principal principal) {
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/constructor")
    public String getPageConstructor(Model model, Principal principal) {
        model.addAttribute("title", "Constructor");
        return "constructor";
    }
}
