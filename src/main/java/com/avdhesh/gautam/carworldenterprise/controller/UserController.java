package com.avdhesh.gautam.carworldenterprise.controller;

import com.avdhesh.gautam.carworldenterprise.models.Car;
import com.avdhesh.gautam.carworldenterprise.models.User;
import com.avdhesh.gautam.carworldenterprise.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/admin/users")
    public ResponseEntity<String> createAllUsers(@RequestBody List<User> users)
    {
        return new ResponseEntity<>(userService.createAllUsers(users), HttpStatus.CREATED);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/public/users/{userId}")
    public ResponseEntity<String> getUserById(@PathVariable Long userId)
    {
        try
        {
            return new ResponseEntity<>(userService.getUserById(userId).toString(), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @PatchMapping("/public/users/{userId}")
    public ResponseEntity<String> updateCar(@RequestBody User user, @PathVariable Long userId)
    {
        try
        {
            return new ResponseEntity<>(userService.updateUserById(user, userId), HttpStatus.OK);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

    @DeleteMapping("/public/users/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId)
    {
        try
        {
            return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.NO_CONTENT);
        }
        catch (ResponseStatusException responseStatusException)
        {
            return new ResponseEntity<>(responseStatusException.getMessage(), responseStatusException.getStatusCode());
        }
    }

}
