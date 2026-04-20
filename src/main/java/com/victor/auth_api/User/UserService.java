package com.victor.auth_api.User;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.victor.auth_api.User.dto.RegisterUserRequest;
import com.victor.auth_api.User.dto.LoginUserRequest;
import com.victor.auth_api.User.dto.LoginResponse;
import com.victor.auth_api.User.dto.RegisterResponse;
import com.victor.auth_api.security.jwt.JwtUtil;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public RegisterResponse registerNewUser(User user){
        userRepository.save(user);

        return new RegisterResponse("Sign up successful", user.getEmail());
    }

    public RegisterResponse registerNewUsers(RegisterUserRequest request){

        if (!request.getPassword().equals(request.getConfirmPassword())) {
        throw new RuntimeException("Passwords do not match");
    }
    
        User user = new User(
            null,
            request.getName(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword()),
            request.getPhone(),
            "USER",
            true,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
        return registerNewUser(user);
    }

    public LoginResponse loginUser(LoginUserRequest request){
        User user =  userRepository.findByEmail(request.getEmail())
                    .orElseThrow(()-> new RuntimeException("User not Found"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid login details");
        }

        String token = JwtUtil.generateToken(user.getEmail());

        return new LoginResponse("Login Successful", token, user.getEmail());
    }
}
