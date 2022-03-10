package com.wolfhack.diploma.Controllers.page;

import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.dto.mapper.UserMapper;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.service.UserDetailService;
import com.wolfhack.diploma.models.users.CustomUserDetails;
import com.wolfhack.diploma.validator.AuthenticationConstraint;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.security.Principal;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.data.crossstore.ChangeSetPersister.*;


@RequiredArgsConstructor
@Controller
public class RegistrationController {

    private final UserDetailService userService;
    private final UserMapper userMapper;

    @PostMapping("/registration")
    public String registration(@ModelAttribute("User") User user, RedirectAttributes model) throws IOException {
        if (!userService.addUser(user)) {
            model.addFlashAttribute("errorMessage", "Пользователь с таким логином уже существует!");
            return "redirect:/registration?error";
        }

        return "redirect:/login";
    }

    @PostMapping("/changeProfile")
    public ResponseEntity<?> changeProfile(@ModelAttribute("User") UserDto requestUser, @AuthenticationConstraint Authentication authentication,
                                           @RequestParam("photoFile") MultipartFile photo) throws NotFoundException {
        User user = userMapper.toUser(requestUser);
        Long id = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        user.setId(id);

        userService.edit(user, photo);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/registration")
    public String SuccessRegistration(Model model, Principal principal) { return "register"; }

    @GetMapping("/login")
    public String login(Model model, Principal principal) { return "login"; }

    @GetMapping("/?logout")
    public String logout(Model model, Principal principal) { return "redirect:/logout"; }
}
