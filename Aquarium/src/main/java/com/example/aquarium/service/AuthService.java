package com.example.aquarium.service;


import com.example.aquarium.bean.request.LoginRequest;
import com.example.aquarium.bean.request.UserDTO;
import com.example.aquarium.bean.response.AuthResponse;
import com.example.aquarium.bean.response.MessageResponse;
import com.example.aquarium.model.Role;
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


    public AuthResponse registerUser(UserDTO userDto) throws Exception {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new Exception("Username is already taken!");
        }
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        Optional<Role> optionalRole = roleRepository.findById(userDto.getRoleId());
        Role role = optionalRole.get();
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encodedPassword);
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setAccountStatus(userDto.getAccountStatus());
        user.setRole(role);
        userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user.getEmail());


        return new AuthResponse(token);
    }

}




