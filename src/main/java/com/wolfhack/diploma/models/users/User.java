package com.wolfhack.diploma.models.users;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "User", catalog = "user_datas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

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
        return roles.iterator().next().getRole().equals("ADMIN") ? true : false;
    }


    @Transient
    public String getPhoto() {
        if (photo == null) {
            return null;
        }
        return "photos/profiles-photos/Profile_" + username +"_"+ user_id + "/" + photo;
    }
    public String getPhotoName() {
        return photo;
    }
    public void setPhoto(String photo) { this.photo = photo; }
}
