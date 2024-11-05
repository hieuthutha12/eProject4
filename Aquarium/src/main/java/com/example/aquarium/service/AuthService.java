package com.example.aquarium.service;


import com.example.aquarium.bean.request.LoginRequest;
import com.example.aquarium.bean.request.PasswordChangeRequest;
import com.example.aquarium.bean.request.UserDTO;
import com.example.aquarium.bean.response.AuthResponse;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.exception.ResourceNotFoundException;
import com.example.aquarium.model.Role;
import com.example.aquarium.model.Status;
import com.example.aquarium.model.User;
import com.example.aquarium.repository.RoleRepository;
import com.example.aquarium.repository.UserRepository;
import com.example.aquarium.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    public MessageResponse loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return new MessageResponse("Invalid username", Map.of("email", "User not found"));
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new MessageResponse("Invalid password", Map.of("password", "Incorrect password"));
        }

        String token = jwtTokenProvider.generateToken(loginRequest.getEmail());
        return new MessageResponse("Login successful " + token, null);
    }

    public MessageResponse changePassword(Integer id, PasswordChangeRequest passwordChangeRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        if (!passwordEncoder.matches(passwordChangeRequest.getOldPassword(), user.getPassword())) {
            return new MessageResponse("Invalid password", Map.of("oldPassword", "Incorrect old password"));
        }

        String encodedPassword = passwordEncoder.encode(passwordChangeRequest.getNewPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return new MessageResponse("Password changed successfully");
    }

    public AuthResponse registerUser(UserDTO userDto) throws Exception {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new Exception("Username is already taken!");
        }
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        Optional<Role> optionalRole = Optional.ofNullable(roleRepository.findById(1));
        Role role = optionalRole.get();
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encodedPassword);
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setAccountStatus(Status.ACTIVE.toString());
        user.setRole(role);
        userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user.getEmail());


        return new AuthResponse(token);
    }

}




