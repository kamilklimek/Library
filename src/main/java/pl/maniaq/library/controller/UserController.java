package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.maniaq.library.model.User;
import pl.maniaq.library.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
            value="/register",
            method= RequestMethod.POST,
            headers="Accept=application/json")
    public String registerUser(
            @PathVariable("login") String login,
            @PathVariable("email") String email,
            @PathVariable("password") String password){

        User user = new User.UserBuilder()
                .setLogin(login)
                .setEmail(email)
                .setPassword(password)
                .createUser();

        return userService.registerUser(user) ? "Registered. " : "Error.";
    }


}
