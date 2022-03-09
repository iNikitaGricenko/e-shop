package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.dto.mapper.UserMapper;
import com.wolfhack.diploma.models.users.User;
import com.wolfhack.diploma.repository.RoleRepository;
import com.wolfhack.diploma.repository.UserRepository;
import com.wolfhack.diploma.service.FileUploadUtil;
import com.wolfhack.diploma.service.UserDetailService;
import com.wolfhack.diploma.service.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class UserRest {

    private final UserDetailService userDetailService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAll() {
        return userDetailService.getAll()
                .stream()
                .map(userMapper::toDto)
                .collect(toList());
    }
}
