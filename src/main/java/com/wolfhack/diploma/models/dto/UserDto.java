package com.wolfhack.diploma.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String login;
    private final String username;
    private final String password;
    private final String firstName;
    private final String secondName;
    private final String middleName;
    private final String phone;
    private final String city;
    private final Date registerDate;
    private final Set<RoleDto> roles;
    private final String photo;
}
