package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.errors.ModelError;
import pl.maniaq.library.exceptions.AuthorExistException;
import pl.maniaq.library.exceptions.AuthorNotFoundException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.enums.CrudOperations;
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
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json"
    )
    public ResponseEntity<String> createAuthor(@RequestBody Author author) throws IOException {
        ResponseEntity<String> response;

        try {
            author = authorService.addNewAuthor(author).get();
            response = ResponseEntity.ok(objectMapper.writeValueAsString(author));

        } catch (AuthorExistException e) {
            e.printStackTrace();
            response = ResponseEntity.badRequest().body(objectMapper.writeValueAsString(new ModelError(Author.class, "Author with these parameters already exist.", CrudOperations.CREATE)));

        } catch (IOException ex) {
            ex.printStackTrace();
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Content that you provide is incorrect.");
        }

        return response;
    }

    @RequestMapping(
            value="/{id}",
            method={RequestMethod.DELETE}
    )
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
            method={RequestMethod.PUT},
            consumes="application/json"
            produces="application/json"
    )
    public ResponseEntity<String> updateAuthor(@RequestBody Author author) {
        ResponseEntity<String> response;
        //zwrócić authora po update
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
