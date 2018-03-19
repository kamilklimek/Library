package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.model.User;
import pl.maniaq.library.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
            value="/register",
            method= RequestMethod.POST
            )
    public String registerUser(
            @RequestBody String login,
            @RequestBody String email,
            @RequestBody String password){

        User user = new User.UserBuilder()
                .setLogin(login)
                .setEmail(email)
                .setPassword(password)
                .createUser();

        return userService.registerUser(user) ? "Registered. " : "Error.";
    }

    @RequestMapping(
            value="/users",
            method=RequestMethod.GET)
    public List<User>  getAllUsers(){
        List<User> users = userService.getAllUsers();

        return users;
    }



}
