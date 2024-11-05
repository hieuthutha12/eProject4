package com.example.aquarium.service;

import com.example.aquarium.bean.request.UserDTO;
import com.example.aquarium.bean.request.UserRequest;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.bean.response.UserResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
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
    public MessageResponse updateUser(int userId, UserRequest userRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setAddress(userRequest.getAddress());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
        return new MessageResponse("Successfully");
    }
}

