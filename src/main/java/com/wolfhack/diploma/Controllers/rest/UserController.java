package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.users.CustomUserDetails;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.validator.AuthenticationConstraint;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public User getAuthenticatedUser(@AuthenticationConstraint Authentication authentication) {
        return ((CustomUserDetails) authentication.getPrincipal()).getUser();
    }
}
