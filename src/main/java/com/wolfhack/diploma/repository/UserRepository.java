package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    boolean existsUserByLogin(String login);
}
