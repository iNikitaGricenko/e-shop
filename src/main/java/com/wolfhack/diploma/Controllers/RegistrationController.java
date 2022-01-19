package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.service.User.UserDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.security.Principal;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@Controller
public class RegistrationController {

    private final UserDetailService userService;

    @PostMapping("/registration")
    public String registration(@ModelAttribute("User") User user, RedirectAttributes model) throws IOException {
        if (!userService.addUser(user)) {

            model.addFlashAttribute("errorMessage", "Пользователь с таким логином уже существует!");
            return "redirect:/registration?error";
        }

        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String SuccessRegistration(Model model, Principal principal) { return "register"; }

    @GetMapping("/login")
    public String login(Model model, Principal principal) { return "login"; }

    @GetMapping("/?logout")
    public String logout(Model model, Principal principal) { return "redirect:/logout"; }
}
