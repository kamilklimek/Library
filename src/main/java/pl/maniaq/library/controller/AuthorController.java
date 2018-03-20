package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maniaq.library.service.AuthorService;

@RestController
@RequestMapping(value="/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    public AuthorController(){

    }

}
