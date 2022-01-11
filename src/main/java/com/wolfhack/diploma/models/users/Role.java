package com.wolfhack.diploma.models.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {}

    @Override
    public String toString() {
        return role;
    }
}
