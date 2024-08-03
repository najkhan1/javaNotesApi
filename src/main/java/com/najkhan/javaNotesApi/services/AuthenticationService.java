package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.RegisterUserDto;
import com.najkhan.javaNotesApi.model.Users;
import com.najkhan.javaNotesApi.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import  com.najkhan.javaNotesApi.model.LoginUserDto;

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

    public Users signup(RegisterUserDto input) {
        Users user = Users.builder()
                .id(input.getId())
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword())).build();

        return userRepository.save(user);
    }

    public Users authenticate(LoginUserDto input) {
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
