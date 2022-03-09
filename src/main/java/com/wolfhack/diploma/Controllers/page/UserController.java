package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.repository.RoleRepository;
import com.wolfhack.diploma.repository.UserRepository;
import com.wolfhack.diploma.models.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/changeProfile")
public class UserController{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

}
