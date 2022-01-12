package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.FileUploadService.FileUploadUtil;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.RoleRepository;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/changeProfile")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostMapping
    public String changeProfile(@RequestParam("photo") MultipartFile photo,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("secondName") String secondName,
                                @RequestParam("middleName") String middleName,
                                @RequestParam("phone") String phone,
                                @RequestParam("city") String city,
                                @RequestParam("login") String email,
                                @RequestParam("password") String password,
                                Model model, Principal principal) throws IOException {
        if (principal!=null) {
            User user = userRepository.findByLogin(principal.getName());
            String fileName = StringUtils.cleanPath(photo.getContentType().replaceAll("image/", ""));
            if (!fileName.contains("application/octet-stream")) {
                user.setPhoto("Profile."+fileName);
            }
            user.setLogin(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setMiddleName(middleName);
            user.setPhone(phone);
            user.setCity(city);

            User savedUser = userRepository.save(user);
            String uploadDir = "photos/profiles-photos/Profile_" + savedUser.getUsername() +"_"+ savedUser.getUser_id();

            FileUploadUtil.trySaveFile(uploadDir, "Profile."+fileName, photo);
            model.addAttribute("login", principal.getName());
        }
        return "redirect:/";
    }

    @GetMapping
    public String userList(Model model, Principal principal) {

        User user = userRepository.findByLogin(principal.getName());

        model.addAttribute("profile_image", '/' + user.getPhoto());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("secondName", user.getSecondName());
        model.addAttribute("middleName", user.getMiddleName());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("city", user.getCity());
        model.addAttribute("registerDate", user.getRegisterDate());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("Role", user.getRoles().iterator().next().getRole());

        model.addAttribute("User", user);

        return "redirect:/";
    }
}
