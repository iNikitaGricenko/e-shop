package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.AttributeService.AuthorizedModel;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.RoleRepository;
import com.wolfhack.diploma.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.sql.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class RegistrationController extends AuthorizedModel {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostMapping("/registration")
    public String registration(@ModelAttribute("User") @Valid User user, BindingResult bindingResult,
                               Model model, Principal principal) throws IOException {

        if (userRepository.existsUserByLogin(user.getLogin())) {
            model.addAttribute("errorMessage", "Пользователь с таким логином уже существует!");
            return "register";
        }

        user.setRoles(roleRepository.findById(2L).stream().collect(Collectors.toSet()));

        Date date = new Date(Calendar.getInstance().getTime().getTime());
        user.setRegisterDate(date);
        user.setPhoto("user-icon.png");

        User savedUser = userRepository.save(user);

        File in = new File(new File("").getAbsolutePath() + "/photos/profiles-photos/user-icon.png");
        File out = new File(new File("").getAbsolutePath() + "/photos/profiles-photos/Profile_" + savedUser.getUsername() +"_"+savedUser.getUser_id());

        out.mkdirs();
        out = new File(out.getAbsolutePath()+"/"+"user-icon.png");
        FileCopyUtils.copy(in, out);

        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String SuccessRegistration(Model model, Principal principal)
    {
        model.addAttribute("User", new User());
        return "register";
    }

    @GetMapping("/login")
	public String login(Model model, Principal principal) { return "login"; }

    @GetMapping("/?logout")
	public String logout(Model model, Principal principal) { return "redirect:/logout"; }
}
