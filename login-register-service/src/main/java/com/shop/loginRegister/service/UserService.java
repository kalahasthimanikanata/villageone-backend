package com.shop.loginRegister.service;

import com.shop.loginRegister.dto.LoginRequest;
import com.shop.loginRegister.dto.RegisterRequest;
import com.shop.loginRegister.model.User;
import com.shop.loginRegister.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(LoginRequest request) {
        return userRepository.findByUsernameAndPasswordAndPhone(
                request.getUsername(),
                request.getPassword(),
                request.getPhone()
        );
    }

    public String register(RegisterRequest request) {

        if (!request.getPassword().equals(request.getReEnterPassword())) {
            return "Password mismatch";
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            return "Mobile number already registered";
        }

        User user = new User();
        user.setCompanyName(request.getCompanyName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPincode(request.getPincode());

        userRepository.save(user);
        return "Registration successful";
    }
}
