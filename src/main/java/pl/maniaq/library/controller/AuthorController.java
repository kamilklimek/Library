package pl.maniaq.library.controller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.exceptions.AuthorExistException;
import pl.maniaq.library.exceptions.AuthorNotFoundException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.service.AuthorService;
import pl.maniaq.library.wrappers.ObjectMapperWrapper;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/authors")
public class AuthorController {

    AuthorService authorService;
    ObjectMapperWrapper objectMapper;

    @Autowired
    public AuthorController(AuthorService authorService, ObjectMapperWrapper objectMapper){
        this.authorService=authorService;
        this.objectMapper = objectMapper;
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
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        ResponseEntity<String> response;

        try {
            author = authorService.addNewAuthor(author).get();
            response = ResponseEntity.ok(objectMapper.writeValueAsString(author));

        } catch (AuthorExistException e) {
            e.printStackTrace();
            response = ResponseEntity.badRequest().body("Author already exists");

        } catch (IOException ex) {
            ex.printStackTrace();
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Content that you provide is incorrect.");
        }

        return response;
    }

    @RequestMapping(
            value="/{id}",
            method={RequestMethod.DELETE})
    public ResponseEntity<String> deleteAuthor(@PathVariable(value="id") Long id) {
        ResponseEntity<String> response;

        try {
            authorService.removeAuthor(id);
            response = ResponseEntity.ok().build();
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
            response = ResponseEntity.notFound().build();
        }

        return response;
    }

    @RequestMapping(
            value="",
            method={RequestMethod.PUT})
    public ResponseEntity<String> updateAuthor(@RequestBody Author author) {
        ResponseEntity<String> response;

        try {
            authorService.updateAuthor(author);
            response = ResponseEntity.ok().build();
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
            response = ResponseEntity.notFound().build();
        }

        return response;
    }



}
