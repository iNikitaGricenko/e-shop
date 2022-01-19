package com.wolfhack.diploma.service.User;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;
import java.util.Calendar;
import java.sql.Date;
import java.io.IOException;
import java.io.File;

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

        Date date = new Date(Calendar.getInstance().getTime().getTime());
        user.setRegisterDate(date);
        user.setPhoto("user-icon.png");

        User savedUser = userRepository.save(user);

        photoCatalog = "/photos/profiles-photos";
        File in = new File(new File("").getAbsolutePath() + photoCatalog + "/user-icon.png");
        File out = new File(new File("").getAbsolutePath() + photoCatalog + "/Profile_" + savedUser.getUsername() +"_"+savedUser.getUser_id());

        out.mkdirs();
        out = new File(out.getAbsolutePath()+"/"+"user-icon.png");
        FileCopyUtils.copy(in, out);

        return true;
    }
}
