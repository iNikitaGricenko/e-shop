package com.wolfhack.diploma.service.AttributeService;

import org.springframework.ui.Model;

import java.security.Principal;

public interface AuthorizedAttributeService {
    Model addAuthorizedAttribute(Model model, Principal principal);
}
