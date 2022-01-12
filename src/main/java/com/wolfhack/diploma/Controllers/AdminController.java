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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

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

		/* first chart */
		model.addAttribute("data_traffic_value1", "1200");
		model.addAttribute("data_traffic_value2", "1900");
		model.addAttribute("data_traffic_value3", "3000");
		/* second chart */
		model.addAttribute("data_january", "1200");
		model.addAttribute("data_february", "1090");
		model.addAttribute("data_march", "3000");
		model.addAttribute("data_april", "5400");
		model.addAttribute("data_may", "1220");
		model.addAttribute("data_june", "1510");
		model.addAttribute("data_july", "3600");
		model.addAttribute("data_august", "4890");
		model.addAttribute("data_september", "2127");
		model.addAttribute("data_october", "1321");
		model.addAttribute("data_november", "1054");
		model.addAttribute("data_december", "4521");

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
