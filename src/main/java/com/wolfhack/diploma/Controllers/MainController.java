package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.AttributeService.AuthorizedModel;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class MainController extends AuthorizedModel {

    private final UserRepository userRepository;

    @PostMapping("/search")
    public String Search(@RequestParam String search, Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", search);

        return "redirect:/";
    }

    @GetMapping("/about")
    public String GetPageIndex(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Home page");
        return "index";
    }

    @GetMapping("/")
    public String GetPageHome(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Home page");
        return "home";
    }

}
