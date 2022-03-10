package com.wolfhack.diploma.models.users;

public enum Role {
    ADMIN, USER;

    @Override
    public String toString() {
        return "ROLE_"+name();
    }
}
