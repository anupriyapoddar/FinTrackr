package com.anupriyap.FinTrackr.controller;

import com.anupriyap.FinTrackr.dto.RegisterRequest;
import com.anupriyap.FinTrackr.model.User;
import com.anupriyap.FinTrackr.security.JwtUtil;
import com.anupriyap.FinTrackr.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/verify")
    public String verify(@RequestParam String email, @RequestParam String otp) {
        return userService.verifyOtp(email, otp);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existing = userService.findByEmail(user.getEmail());

        if (!userService.matchPassword(user.getPassword(), existing.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (!existing.isActive()) {
            throw new RuntimeException("User not verified");
        }

        return jwtUtil.generateToken(
                existing.getEmail(),
                existing.getRole().name()
        );
    }
}
