package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.dto.UserDto;
import com.wolfhack.diploma.models.dto.mapper.UserMapper;
import com.wolfhack.diploma.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class AdminUserRestController {

    private final UserDetailService userDetailService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAll() {
        return userDetailService.getAll()
                .stream()
                .map(userMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable("id") Long id) {
        return userMapper.toDto(userDetailService.getOne(id));
    }
}
