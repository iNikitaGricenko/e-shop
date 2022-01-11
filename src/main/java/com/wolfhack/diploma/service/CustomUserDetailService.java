package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        CustomUserDetails userDetails = null;
        if (user!=null) {
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        } else {
            System.out.println("User not exist with email : " + login);
            throw new UsernameNotFoundException("User not exist with email : " + login);
        }

        return userDetails;
    }
}
