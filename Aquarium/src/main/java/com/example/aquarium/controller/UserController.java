package com.example.aquarium.controller;

import com.example.aquarium.bean.response.UserInfo;
import com.example.aquarium.bean.response.UserResponse;
import com.example.aquarium.model.LoyaltyPoints;
import com.example.aquarium.model.Role;
import com.example.aquarium.model.User;
import com.example.aquarium.security.jwt.JwtTokenProvider;
import com.example.aquarium.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserInfo> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            String email = jwtTokenProvider.extractEmail(token);
            User user = userService.findByEmail(email);
            Role role = userService.findRoleByUserId(user.getId());
            LoyaltyPoints loyaltyPoints = userService.findLoyaltyPointsByUserId(user.getId());
            return ResponseEntity.ok(new UserInfo(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getAccountStatus(),
                    role.getRoleName(),
                    loyaltyPoints != null ? loyaltyPoints.getPoints() : 0,
                    loyaltyPoints != null ? loyaltyPoints.getDiscountPercentage().doubleValue() : 0.0,
                    loyaltyPoints != null ? loyaltyPoints.getCreatedAt() : new Date()
            ));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/checkToken")
    public ResponseEntity<String> checkToken(@RequestParam String token) {
        if (token == null || token.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Token is missing or empty");
        }
        if (jwtTokenProvider.validateToken(token)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}


