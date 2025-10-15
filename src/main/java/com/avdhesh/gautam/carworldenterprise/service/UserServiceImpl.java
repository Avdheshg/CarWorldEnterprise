package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.User;
import com.avdhesh.gautam.carworldenterprise.repositories.UserRespository;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRespository userRepository;

    public String createAllUsers(List<User> allUsers)
    {
        userRepository.saveAll(allUsers);

        return "Users added!";
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long userId)
    {
        Optional<User> foundUser = userRepository.findById(userId);

        return foundUser
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with the given Id: " + userId));

    }

    public String updateUserById(User newUser, Long userId)
    {
        User foundUser = getUserById(userId);

        if (newUser.getName().isBlank() == false)
        {
            foundUser.setName(newUser.getName());
            userRepository.save(foundUser);
        }

        return "User updated with the Id: " + userId;
    }

    public String deleteUserById(Long userId)
    {
        userRepository.deleteById(userId);
        return "User deleted with the Id: " + userId;
    }

}
