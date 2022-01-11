package com.wolfhack.diploma.models.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Getter(AccessLevel.NONE)
    private String photo;
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

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
    public void setPhoto(String photo) { this.photo = photo; }



}
