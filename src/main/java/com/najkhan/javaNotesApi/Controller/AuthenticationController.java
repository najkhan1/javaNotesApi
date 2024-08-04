package com.najkhan.javaNotesApi.Controller;

import com.najkhan.javaNotesApi.model.responses.LoginResponse;
import com.najkhan.javaNotesApi.model.requests.LoginUserRequest;
import com.najkhan.javaNotesApi.model.requests.RegisterUserRequest;
import com.najkhan.javaNotesApi.model.Users;
import com.najkhan.javaNotesApi.model.responses.SignupResponse;
import com.najkhan.javaNotesApi.services.AuthenticationService;
import com.najkhan.javaNotesApi.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> register(@RequestBody RegisterUserRequest registerUserRequest) {
        Users registeredUser = authenticationService.signup(registerUserRequest);
        SignupResponse signupResponse = new SignupResponse(registeredUser.getUsername());
        return ResponseEntity.ok(signupResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserRequest loginUserRequest) {
        Users authenticatedUser = authenticationService.authenticate(loginUserRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse
                .builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }
}
