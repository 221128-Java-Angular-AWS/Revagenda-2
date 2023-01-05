package com.revagenda.controllers;

import com.revagenda.exceptions.IncorrectPasswordException;
import com.revagenda.exceptions.UserNotFoundException;
import com.revagenda.models.User;
import com.revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles login requests. Registration is handled by the UserController POST method.
 * The @RestController annotation indicates this is a Controller for component scanning as well as
 * implying @ResponseBody on all methods. @RequestMapping sets the path to this class as "/auth"
 *
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    //We need a bean of our UserService class in order to invoke its methods.
    private UserService userService;

    /*
    We autowire in dependencies here. This is constructor autowiring. Remember, constructor and
    setter wiring is good. But, field injection is bad. Never put @Autowired on a field, only on methods.
    This annotation tells Spring that when this constructor is invoked by the bean factory (or application context)
    that it should find a corresponding bean by type and pass it here to the constructor.
     */
    @Autowired
    public AuthController(UserService userService) {
        System.out.println("Auth Controller constructor...");
        this.userService = userService;
    }

    /**
     * Post a username and password in the JSON body and login. Throws one of two
     * exceptions if username or password are incorrect.
     * @param user - This is the user object to be built out of the request body JSON.
     *             It only needs a username and password populated.
     * @throws UserNotFoundException - if username not found in database
     * @throws IncorrectPasswordException - if password does not match database
     */
    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void authenticateUser(@RequestBody User user) throws UserNotFoundException, IncorrectPasswordException {
        userService.authenticateUser(user.getUsername(), user.getPassword());
        //TODO: if successful generate and return a cookie


    }


    /*
    We can do exception handling in one of two ways. Traditionally, these below exception handlers are
    for handling pre-defined checked exceptions, like SQLException or IOException.
    You can also handle custom exceptions in this way, but you could just place the @ResponseStatus
    annotation on your custom exception in order to have the server respond with that code whenever
    the exception gets thrown.
     */

    /*
    @ExceptionHandler(UserNotFoundException.class)
    public void badUsernameHandler() {

    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public void badPassHandler() {

    }
    */


}
