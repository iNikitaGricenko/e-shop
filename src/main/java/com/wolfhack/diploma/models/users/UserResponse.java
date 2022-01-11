package com.wolfhack.diploma.models.users;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class UserResponse {
    private Long user_id;

    private String login;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private String city;
    private Date registerDate;
    private String photo;
    private boolean active;
}
