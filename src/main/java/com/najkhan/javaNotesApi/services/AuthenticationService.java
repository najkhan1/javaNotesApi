package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.requests.RegisterUserRequest;
import com.najkhan.javaNotesApi.model.Users;
import com.najkhan.javaNotesApi.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.najkhan.javaNotesApi.model.requests.LoginUserRequest;

@Service
public class AuthenticationService {
    private final UsersRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsersRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users signup(RegisterUserRequest input) {
        Users user = Users.builder()
                .id(input.getId())
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword())).build();

        return userRepository.save(user);
    }

    public Users authenticate(LoginUserRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
