package com.wolfhack.diploma.Controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.dto.mapper.UserMapper;
import com.wolfhack.diploma.models.users.CustomUserDetails;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.service.UserDetailService;
import com.wolfhack.diploma.validator.AuthenticationConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDetailService userService;
    private final UserMapper userMapper;

    @GetMapping
    public User getAuthenticatedUser(@AuthenticationConstraint Authentication authentication) {
        return ((CustomUserDetails) authentication.getPrincipal()).getUser();
    }

    @PostMapping
    public ResponseEntity<?> edit(@RequestPart("photoFile") MultipartFile photo,
                                  @RequestPart("requestUser") String requestUser,
                                  @AuthenticationConstraint Authentication authentication) {
        User user = new User();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            user = objectMapper.readValue(requestUser, User.class);
            User authenticatedUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

            Long id = authenticatedUser.getId();
            user.setId(id);

            user = userService.edit(user, photo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(user);
    }
}
