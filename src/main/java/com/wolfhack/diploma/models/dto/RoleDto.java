package com.wolfhack.diploma.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class RoleDto implements Serializable {
    private final Long role_id;
    private final String role;
    private final Set<UserDto> users;
}
