package custom_key.controllers;

import custom_key.exceptions.AuthenticationException;
import custom_key.exceptions.GeneralException;
import custom_key.models.User;
import custom_key.services.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import custom_key.services.user.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by ryandesmond on 4/6/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/")
    public ArrayList<User> getAllUsers(@RequestParam("api-key") String apiKey) throws AuthenticationException {

        if (securityService.authenticateApiKey(apiKey))
            return userService.getAllUsers();
        else
            throw new AuthenticationException("Invalid API Key.");

    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value="id") Integer id,
                            @RequestParam("api-key") String apiKey) throws GeneralException, AuthenticationException {

        if (securityService.authenticateApiKey(apiKey))
            return userService.getUserById(id);
        else
            throw new AuthenticationException("Invalid API Key.");
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws GeneralException, NoSuchAlgorithmException {

        return userService.createUser(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) throws GeneralException, AuthenticationException {

        if (securityService.authenticateApiKey(user.getApiKey()))
            return userService.updateUser(user);
        else
            throw new AuthenticationException("Invalid API Key.");

    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable(value="id") Integer id,
                           @RequestParam("api-key") String apiKey) throws GeneralException, AuthenticationException {

        if (securityService.authenticateApiKey(apiKey))
            return userService.deleteUser(id);
        else
            throw new AuthenticationException("Invalid API Key.");
    }

}
