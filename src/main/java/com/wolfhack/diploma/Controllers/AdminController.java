package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.AttributeService.AuthorizedModel;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Controller
public class AdminController extends AuthorizedModel {

    private final UserRepository userRepository;
	private UserDetailsService userDetailsService;

	@PostMapping("/search")
    public String Search(@RequestParam String search, Model model, Principal principal) {
		addAuthorizedAttribute(model, principal)
				.addAttribute("title", search);

        return "redirect:/admin";
    }

    @GetMapping
	public String getPageAdminPanel(Model model, Principal principal) {
		addAuthorizedAttribute(model, principal)
				.addAttribute("title", "Админ панель");

    	return "admin/admin";
	}

    @GetMapping("/customers")
	public String getPageAdminCustomers(Model model, Principal principal) {
		addAuthorizedAttribute(model, principal);
		/* first chart */
		model.addAttribute("data_online_traffic_value1", "50");
		model.addAttribute("data_offline_traffic_value2", "20");

    	return "admin/customers";
	}

    @GetMapping("/messages")
	public String getPageAdminMessages(Model model, Principal principal) {
		addAuthorizedAttribute(model, principal);

    	return "admin/messages";
	}

    @GetMapping("/setup")
	public String getPageAdminSetup(Model model, Principal principal) {
		addAuthorizedAttribute(model, principal);

    	return "admin/setup";
	}

    @GetMapping("/settings")
	public String getPageAdminSettings(Model model, Principal principal) {
		addAuthorizedAttribute(model, principal);

    	return "admin/settings";
	}

}
