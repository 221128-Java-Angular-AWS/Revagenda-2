package com.revagenda.controllers;

import com.revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/*
POST - authenticate with username and password
 */

@RestController
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        System.out.println("Auth Controller constructor...");
        this.userService = userService;
    }


}
