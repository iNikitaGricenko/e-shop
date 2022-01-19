package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class MainController {

    private final UserRepository userRepository;

    @ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

    @PostMapping("/search")
    public String Search(@RequestParam String search, Model model, Principal principal) {
        model.addAttribute("title", search);

        return "redirect:/";
    }

    @GetMapping("/about")
    public String GetPageIndex(Model model, Principal principal) {
        model.addAttribute("title", "Home page");
        return "index";
    }

    @GetMapping
    public String GetPageHome(Model model, Principal principal) {
        model.addAttribute("title", "Home page");
        return "home";
    }
}
