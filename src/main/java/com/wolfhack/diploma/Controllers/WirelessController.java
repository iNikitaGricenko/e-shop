package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.AttributeService.AuthorizedModel;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/wireless")
public class WirelessController extends AuthorizedModel {

    private final UserRepository userRepository;

    @GetMapping
    public String getPage(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "products/wireless";
    }

    @GetMapping("/wifi-routers")
    public String getPageWifiRouters(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/switches")
    public String getPageSwitches(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/wireless/network-cards")
    public String getPageNetworkCards(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/wireless/wifi-adapters")
    public String getPageWifiAdapters(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/powerlines")
    public String getPagePowerlines(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/network-cabels")
    public String getPageNetworkCabels(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
    @GetMapping("/antennas")
    public String getPageAntennas(Model model, Principal principal) {
        addAuthorizedAttribute(model, principal)
                .addAttribute("title", "Wireless");
        return "";
    }
}
