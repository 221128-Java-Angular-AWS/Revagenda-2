package com.revagenda.controllers;

import com.revagenda.exceptions.IncorrectPasswordException;
import com.revagenda.exceptions.UserNotFoundException;
import com.revagenda.models.User;
import com.revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
POST - authenticate with username and password
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        System.out.println("Auth Controller constructor...");
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void authenticateUser(@RequestBody User user) throws UserNotFoundException, IncorrectPasswordException {
        userService.authenticateUser(user.getUsername(), user.getPassword());
        //TODO: if successful generate and return a cookie

    }


    /*
    Included the response status annotation on the custom exceptions.
     */


//    @ExceptionHandler(UserNotFoundException.class)
//    public void badUsernameHandler() {
//
//    }
//
//    @ExceptionHandler(IncorrectPasswordException.class)
//    public void badPassHandler() {
//
//    }



}
