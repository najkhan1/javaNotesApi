package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Users;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)

public class JwtServiceTest {

    @InjectMocks
    JwtService jwtService;

    @DisplayName("extractUserName should extract correct username")
    @Test
    public void extractUsernameTest() {
        ReflectionTestUtils.setField(jwtService,"secretKey","10FFD57055153C374F5EE576F703213F4FC66E485F08C8DE8ACC5DD4D266240E");
        ReflectionTestUtils.setField(jwtService,"jwtExpiration",1000000);
        UserDetails userDetails = Users
                .builder()
                .id(1)
                .email("test@test")
                .fullName("test")
                .password("test")
                .build();
        String token = jwtService.generateToken(userDetails);
        String result = jwtService.extractUsername(token);
        Assertions.assertEquals(result,userDetails.getUsername());
    }

    @DisplayName("extractUserName should throw exception when jwt signature does not match")
    @Test
    public void whenSignatureDoesNotMatch_thenExtractUsername_throwsException() {
        ReflectionTestUtils.setField(jwtService,"secretKey","10FFD57055153C374F5EE576F703213F4FC66E485F08C8DE8ACC5DD4D266240E");
        ReflectionTestUtils.setField(jwtService,"jwtExpiration",1000000);
        UserDetails userDetails = Users
                .builder()
                .id(1)
                .email("test@test")
                .fullName("test")
                .password("test")
                .build();
        String token = jwtService.generateToken(userDetails) + "randomString";
        Assertions.assertThrows(SignatureException.class, () -> jwtService.extractUsername(token));
    }

}
