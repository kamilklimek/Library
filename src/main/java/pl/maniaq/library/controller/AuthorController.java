package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.service.AuthorService;

import java.util.Date;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    public AuthorController(){

    }

    @RequestMapping(
            value="",
            method= RequestMethod.GET)
    public List<Author> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();

        return authors;
    }

    @RequestMapping(
            value="",
            method=RequestMethod.POST)
    public String addNewAuthor(
            @RequestParam(value="name") String authorName,
            @RequestParam(value="lastname") String authorLastName){
        Author author = new Author(authorName, authorLastName, new Date());

        return authorService.addNewAuthor(author) ? "Ok" : "Error.";
    }

}
