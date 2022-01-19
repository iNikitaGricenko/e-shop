package com.wolfhack.diploma.Controllers;

import com.wolfhack.diploma.service.FileUploadService.FileUploadUtil;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/changeProfile")
public class UserController{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @ModelAttribute("User")
    public User getCurrentUser(Principal principal) {
        if (principal != null) {
            return userRepository.findByLogin(principal.getName());
        } else {
            return null;
        }
    }

    @PostMapping
    public RedirectView changeProfile(@RequestParam("photoFile") MultipartFile photo, @ModelAttribute("User") User requestUser,
                                      Principal principal, RedirectAttributes attributes) throws IOException {
        if (principal == null) {
            throw new AuthorizationServiceException("Not authorized");
        }

        User user = userRepository.findByLogin(requestUser.getLogin());

        requestUser.setUser_id(user.getUser_id());
        requestUser.setUsername(user.getUsername());
        requestUser.setPhoto(user.getPhotoName());

        String fileName = StringUtils.cleanPath(photo.getContentType().replaceAll("image/", ""));

        if (!fileName.contains("application/octet-stream")) {
            requestUser.setPhoto("Profile."+fileName);
        }

        User savedUser = userRepository.save(requestUser);

        String uploadDir = "photos/profiles-photos/Profile_" + savedUser.getUsername() +"_"+ savedUser.getUser_id();
        FileUploadUtil.trySaveFile(uploadDir, "Profile."+fileName, photo);

        attributes.addAttribute("User", savedUser);

        return new RedirectView("/");
    }
}
