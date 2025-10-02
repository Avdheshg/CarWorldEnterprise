package com.avdhesh.gautam.carworldenterprise.service.interfaces;

import com.avdhesh.gautam.carworldenterprise.models.User;

import java.util.List;

public interface UserService
{
    String createAllUsers(List<User> users);
    List<User> getAllUsers();
    User getUserById(Long userId);
    String updateUserById(User user, Long userId);
    String deleteUserById(Long userId);
}
