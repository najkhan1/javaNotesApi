package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Users;
import com.najkhan.javaNotesApi.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository userRepository;

    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> allUsers() {

        return new ArrayList<>(userRepository.findAll());
    }
}
