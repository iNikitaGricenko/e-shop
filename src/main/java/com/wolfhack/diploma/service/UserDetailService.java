package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.users.CustomUserDetails;
import com.wolfhack.diploma.models.users.Role;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private String photoCatalog = "/photos/profiles-photos";

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        CustomUserDetails customUserDetails = null;
        if (user!=null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        } else {
            System.out.println("User not exist with email : " + login);
            throw new UsernameNotFoundException("User not exist with email : " + login);
        }

        return customUserDetails;
    }

    public boolean addUser(User user) throws IOException {
        if (userRepository.existsUserByLogin(user.getLogin())) {
            return false;
        }
        
        user.setRole(Role.USER);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bcryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(bcryptedPassword);

        Date date = new Date(Calendar.getInstance().getTime().getTime());
        user.setRegisterDate(date);
        user.setPhoto("user-icon.png");

        User savedUser = userRepository.save(user);

        File in = new File(new File("").getAbsolutePath() + photoCatalog + "/user-icon.png");
        File out = new File(new File("").getAbsolutePath() + photoCatalog + "/Profile_" + savedUser.getUsername() +"_"+savedUser.getId());

        out.mkdirs();
        out = new File(out.getAbsolutePath()+"/"+"user-icon.png");
        FileCopyUtils.copy(in, out);

        return true;
    }

    @SneakyThrows
    public User edit(User user, MultipartFile photo) {
        User foundedUser = userRepository.findById(user.getId())
                .orElseThrow(NotFoundException::new);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bcryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(bcryptedPassword);
        user.setUsername(foundedUser.getUsername());
        user.setRole(foundedUser.getRole());
        user.setPhoto(foundedUser.getPhotoName());

        String path = photo.getContentType().replaceAll("image/", "");
        String fileName = StringUtils.cleanPath(path);

        if (!fileName.contains("application/octet-stream")) {
            user.setPhoto("Profile."+fileName);
        }

        User savedUser = userRepository.save(user);

        String uploadDir = "photos/profiles-photos/Profile_" + savedUser.getUsername() +"_"+ savedUser.getId();
        FileUploadUtil.trySaveFile(uploadDir, "Profile."+fileName, photo);

        return savedUser;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }
}
