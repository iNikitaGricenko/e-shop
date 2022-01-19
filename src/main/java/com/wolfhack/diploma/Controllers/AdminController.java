package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Controller
public class AdminController {

	private final UserRepository userRepository;
	private UserDetailsService userDetailsService;

	@ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

	@ModelAttribute("Users")
    public List<User> userList() {
        return userRepository.findAll();
    }

	@PostMapping("/search")
	public String Search(@RequestParam String search, Model model, Principal principal) {
		model.addAttribute("title", search);

		return "redirect:/admin";
	}

	@GetMapping
	public String getPageAdminPanel(Model model, Principal principal) {
		model.addAttribute("title", "Админ панель");

		return "admin/admin";
	}

	@GetMapping("/customers")
	public String getPageAdminCustomers(Model model, Principal principal) {
		/* first chart */
		model.addAttribute("data_online_traffic_value1", "50");
		model.addAttribute("data_offline_traffic_value2", "20");

		return "admin/customers";
	}

	@GetMapping("/messages")
	public String getPageAdminMessages(Model model, Principal principal) {

		return "admin/messages";
	}

	@GetMapping("/setup")
	public String getPageAdminSetup(Model model, Principal principal) {

		return "admin/setup";
	}

	@GetMapping("/settings")
	public String getPageAdminSettings(Model model, Principal principal) {

		return "admin/settings";
	}

}
