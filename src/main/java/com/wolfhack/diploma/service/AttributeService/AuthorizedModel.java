package com.wolfhack.diploma.service.AttributeService;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorizedModel implements AuthorizedAttributeService {

    @Autowired
    private UserRepository userRepository;

    private Map<String, Object> attributes = new LinkedHashMap<>();

    public Model addAuthorizedAttribute(Model model, Principal principal) {
        if (principal == null) {
            clearModel();
            return model;
        }

        if (!attributes.isEmpty()) {
            return model.addAllAttributes(attributes);
        }

        attributes.put("User", userRepository.findByLogin(principal.getName()));

        attributes = model.addAllAttributes(attributes).asMap();

        return model;
    }

    private void clearModel() {
        if (!attributes.isEmpty()) {
            attributes.clear();
        }
    }
}
