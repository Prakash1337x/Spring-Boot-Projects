package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository obj;

    // Create User
    public User createUser(User user)
    {
        return obj.save(user);
    }

    // Get By Id
    public User getUserById(Long id)
    {
        return obj.findById(id).orElseThrow(()-> new RuntimeException("User Not Found!.."));
    }
}
