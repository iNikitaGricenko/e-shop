package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}