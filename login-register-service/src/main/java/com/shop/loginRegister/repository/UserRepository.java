package com.shop.loginRegister.repository;

import com.shop.loginRegister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPasswordAndPhone(
            String username, String password, String phone);

    boolean existsByPhone(String phone);
}
