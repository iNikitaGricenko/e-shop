package com.wolfhack.diploma.models.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Getter(AccessLevel.NONE)
    @Column(name = "photo")
    private String photo;

    @Column(name = "active")
    private boolean active;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "register_date")
    private Date registerDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    public boolean isAdmin() {
        return Objects.equals(role.toString(), "ADMIN");
    }

    @Transient
    public String getPhoto() {
        if (photo == null) {
            return null;
        }
        return "photos/profiles-photos/Profile_" + username +"_"+ id + "/" + photo;
    }
    public String getPhotoName() {
        return photo;
    }
    public void setPhoto(String photo) { this.photo = photo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
