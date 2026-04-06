package com.anupriyap.FinTrackr.service;

import com.anupriyap.FinTrackr.dto.RegisterRequest;
import com.anupriyap.FinTrackr.model.Role;
import com.anupriyap.FinTrackr.model.User;
import com.anupriyap.FinTrackr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final String ADMIN_CODE = "ZORVYN@ADMIN2024";

    // 🔹 REGISTER USER
    public User register(RegisterRequest request) {

        Role role = Role.valueOf(request.getRole().toUpperCase());

        // Admin validation
        if (role == Role.ADMIN) {
            if (request.getAdminCode() == null || !request.getAdminCode().equals(ADMIN_CODE)) {
                throw new RuntimeException("Invalid admin code");
            }
        }

        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user.setActive(false);

        // 🔥 Generate OTP
        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        user.setOtp(otp);

        System.out.println("OTP for user: " + otp); // simulate sending

        return userRepository.save(user);
    }

    // 🔹 VERIFY OTP
    public String verifyOtp(String email, String otp) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        user.setActive(true);
        user.setOtp(null);

        userRepository.save(user);

        return "User verified successfully";
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 🔹 PASSWORD MATCH CHECK (used in login)
    public boolean matchPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}