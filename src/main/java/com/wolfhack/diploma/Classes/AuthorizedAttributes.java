package com.wolfhack.diploma.Classes;

import com.wolfhack.diploma.repository.users.UserRepository;
import org.springframework.ui.Model;

import java.security.Principal;

public interface AuthorizedAttributes {
    Model addAuthorizedAttribute(Model model, Principal principal, UserRepository userRepository);
}
