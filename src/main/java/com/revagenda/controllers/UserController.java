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

    @GetMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserByUsername(@PathVariable Integer userId) {
        //do get request
        return new User();
    }

    @PostMapping(value = "/new")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User createNewUser(@RequestBody User newUser) {
        //do post request
        return new User();
    }


    @PutMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User updateUser(@PathVariable Integer userId) {
        //do put request
        return new User();
    }


    @DeleteMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User deleteUser(@PathVariable Integer userId) {
        //do the "delete"
        return new User();
    }

}
