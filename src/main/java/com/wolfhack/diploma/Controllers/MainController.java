package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.Classes.AuthorizedModel;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/")
public class MainController extends AuthorizedModel {

    private final UserRepository userRepository;

    @PostMapping("/search")
    public String Search(@RequestParam String search, Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", search);

        return "redirect:/";
    }

    @GetMapping("/about")
    public String GetPageIndex(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Home page");
        return "index";
    }

    @GetMapping("/")
    public ModelAndView GetPageHome(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal, userRepository)
                .addAttribute("title", "Home page");
        ModelAndView modelAndView = new ModelAndView("home", model.asMap());

        User user = (User) modelAndView.getModel().get("User");
        if (user!=null)
            System.out.println(user.getUser_id());

        return modelAndView;
    }

}
