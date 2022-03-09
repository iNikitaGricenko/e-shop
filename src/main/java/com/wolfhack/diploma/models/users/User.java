package com.wolfhack.diploma.models.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "User", catalog = "user_datas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String login;
    private String username;
    private String password;

    @Getter(AccessLevel.NONE)
    private String photo;

    private boolean active;
    private String activationCode;

    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private String city;
    private Date registerDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            catalog = "user_datas",
            joinColumns = { @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "user_id")
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "role_id")
            })
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public boolean isAdmin() {
        return roles
                .stream()
                .anyMatch(role -> Objects.equals(role.getRole(), "ADMIN"));
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
}
