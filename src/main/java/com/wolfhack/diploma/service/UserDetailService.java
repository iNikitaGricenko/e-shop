package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.RoleRepository;
import com.wolfhack.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
import java.util.stream.Collectors;

import static org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private String photoCatalog;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        UserDetails userDetails = null;
        if (user!=null) {
            userDetails = new UserDetails();
            userDetails.setUser(user);
        } else {
            System.out.println("User not exist with email : " + login);
            throw new UsernameNotFoundException("User not exist with email : " + login);
        }

        return userDetails;
    }

    public boolean addUser(User user) throws IOException {

        if (userRepository.existsUserByLogin(user.getLogin())) {
            return false;
        }
        
        user.setRoles(roleRepository.findById(3L).stream().collect(Collectors.toSet()));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Date date = new Date(Calendar.getInstance().getTime().getTime());
        user.setRegisterDate(date);
        user.setPhoto("user-icon.png");

        User savedUser = userRepository.save(user);

        photoCatalog = "/photos/profiles-photos";
        File in = new File(new File("").getAbsolutePath() + photoCatalog + "/user-icon.png");
        File out = new File(new File("").getAbsolutePath() + photoCatalog + "/Profile_" + savedUser.getUsername() +"_"+savedUser.getId());

        out.mkdirs();
        out = new File(out.getAbsolutePath()+"/"+"user-icon.png");
        FileCopyUtils.copy(in, out);

        return true;
    }

    @SneakyThrows
    public boolean edit(User user, MultipartFile photo) throws NotFoundException {

        User foundedUser = userRepository.findById(user.getId())
                .orElseThrow(NotFoundException::new);

        user.getId();
        user.setUsername(foundedUser.getUsername());
        user.setPhoto(foundedUser.getPhotoName());

        String fileName = StringUtils.cleanPath(photo.getContentType().replaceAll("image/", ""));

        if (!fileName.contains("application/octet-stream")) {
            user.setPhoto("Profile."+fileName);
        }

        User savedUser = userRepository.save(user);

        String uploadDir = "photos/profiles-photos/Profile_" + savedUser.getUsername() +"_"+ savedUser.getId();
        FileUploadUtil.trySaveFile(uploadDir, "Profile."+fileName, photo);

        return true;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
