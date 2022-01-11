package com.wolfhack.diploma.Classes;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorizedModel implements AuthorizedAttributes {

    private User currentUser;
    private final Map<String, Object> attributes = new LinkedHashMap<>();

    public Model addAuthorizedAttribute(Model model, Principal principal, UserRepository userRepository) {
        if (principal == null) {
            exit();
            return model;
        }

        if (!attributes.isEmpty()) {
            model.addAllAttributes(attributes);
        }

        currentUser = userRepository.findByLogin(principal.getName());
        attributes.put("User", currentUser);

        model.addAllAttributes(attributes);
        model.asMap();

        return model;
    }

    private void exit() {
        currentUser = null;
        if (!attributes.isEmpty()) {
            attributes.clear();
        }
    }
}
