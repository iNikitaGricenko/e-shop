package com.wolfhack.diploma.repository.users;

import com.wolfhack.diploma.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    boolean existsUserByLogin(String login);
}
