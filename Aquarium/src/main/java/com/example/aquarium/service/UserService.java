package com.example.aquarium.service;

import com.example.aquarium.bean.response.UserResponse;
import com.example.aquarium.mapper.UserMapper;
import com.example.aquarium.model.LoyaltyPoints;
import com.example.aquarium.model.Role;
import com.example.aquarium.model.User;
import com.example.aquarium.repository.LoyaltyPointsRepository;
import com.example.aquarium.repository.RoleRepository;
import com.example.aquarium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final LoyaltyPointsRepository loyaltyPointsRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Role findRoleByUserId(int userId) {
        return roleRepository.findById(userId);
    }

    public LoyaltyPoints findLoyaltyPointsByUserId(int userId) {
        return loyaltyPointsRepository.findByUserId(userId);
    }
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());

    }
}

