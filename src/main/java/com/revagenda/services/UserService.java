package com.revagenda.services;

import com.revagenda.exceptions.IncorrectPasswordException;
import com.revagenda.exceptions.UserNotFoundException;
import com.revagenda.models.User;
import com.revagenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User authenticateUser(String username, String password) throws UserNotFoundException, IncorrectPasswordException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UserNotFoundException("User " + username + " not found.");
        } else if(!password.equals(user.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password.");
        }

        return user;
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(new User());
    }

    public User updateUser(User changes) {
        User user = userRepo.findById(changes.getId()).orElseThrow();
        user.setEmail(changes.getEmail());
        user.setFirstName(changes.getFirstName());
        user.setLastName(changes.getLastName());
        user.setUsername(changes.getUsername());
        user.setPassword(changes.getPassword());
        return userRepo.save(user);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }
}
