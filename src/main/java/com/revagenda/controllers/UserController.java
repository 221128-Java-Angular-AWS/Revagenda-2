package com.revagenda.controllers;

import com.revagenda.models.User;
import com.revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/*
GET - one user by ID/username?
POST - create a new user, registration
PUT - update a user, change info
DELETE - delete a user, or mark it "deleted"
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        System.out.println("User Controller constructor...");
        this.userService = userService;
    }

    @GetMapping(value = "/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


    @PostMapping(value = "/new")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User createNewUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }


    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    @DeleteMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
    }

}
