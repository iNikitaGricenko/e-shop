package com.wolfhack.diploma.Controllers.page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminController {

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
