package com.avdhesh.gautam.carworldenterprise.service;

import com.avdhesh.gautam.carworldenterprise.models.User;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private List<User> users = new ArrayList<>();
    private Long userId = 1L;

    public String createAllUsers(List<User> allUsers)
    {
        for (User user : allUsers)
        {
            user.setId(getUserId());
            users.add(user);
        }

        return "Users added!";
    }

    public List<User> getAllUsers()
    {
        return users;
    }

    public User getUserById(Long userId)
    {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found with the given Id: " + userId));
    }

    public String updateUserById(User newUser, Long userId)
    {
        User foundUser = getUserById(userId);

        if (newUser.getName().isBlank() == false)
        {
            foundUser.setName(newUser.getName());
        }
        return "User updated with the Id: " + userId;
    }

    public String deleteUserById(Long userId)
    {
        User foundUser = getUserById(userId);
        users.remove(foundUser);
        return "User deleted with the Id: " + userId;
    }

    private Long getUserId()
    {
        return userId++;
    }
}
