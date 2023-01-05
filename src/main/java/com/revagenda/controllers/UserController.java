package com.revagenda.controllers;

import com.revagenda.models.User;
import com.revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles user resource requests (except for auth).
 * The @RestController annotation indicates this is a Controller for component scanning as well as
 * implying @ResponseBody on all methods. @RequestMapping sets the path to this class as "/users"
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

    /**
     * getUserByUsername() will return a resource representation of the user object
     * with the given username. Usernames are unique, so this should only ever return at most
     * one user.
     * @param username - the unique username to identify the specific user resource
     * @return resource representation of the user object found in the database
     */
    @GetMapping(value = "/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


    /**
     * createNewUser() will create a new resource based on the representation sent in the request body JSON.
     * @param newUser json resource representation of the new user object
     * @return a current resource representation of the newly persisted user object
     */
    @PostMapping(value = "/new")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User createNewUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }


    /**
     * updateUser() modifies the persistent object by passing a resource representation
     * containing the new values for the User resource. The id is the only thing that cannot change.
     * @param user resource representation of a User containing the new values to update the object
     * @return a current resource representation of the user that was changed.
     */
    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public @ResponseBody User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }



    /**
     * deleteUser() will delete a user from the database. Later we may
     * want to change this logic to just mark the row as inactive, rather than deleting it from the table.
     * @param userId the userId of the user to be deleted. Path variable found in token ".../users/{userId}"
     */
    @DeleteMapping(value = "/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
    }

}
