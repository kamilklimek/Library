package pl.maniaq.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.model.BodyMessage;
import pl.maniaq.library.exceptions.AuthorExistException;
import pl.maniaq.library.exceptions.AuthorNotFoundException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.assemblers.ModelAssembler;
import pl.maniaq.library.model.assemblers.BodyMessageAssembler;
import pl.maniaq.library.model.enums.CrudOperations;
import pl.maniaq.library.service.AuthorService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/author")
public class AuthorController {

    private AuthorService authorService;
    private ModelAssembler assembler;
    private BodyMessageAssembler bodyMessageAssembler;

    @Autowired
    public AuthorController(AuthorService authorService,
                            ModelAssembler assembler,
                            BodyMessageAssembler bodyMessageAssembler){
        this.authorService=authorService;
        this.assembler =assembler;
        this.bodyMessageAssembler = bodyMessageAssembler;
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
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.CREATE)
                .setModel(Author.class)
                .build();


        try {
            author = authorService.addNewAuthor(author);
            response = ResponseEntity.ok(assembler.getModelObj(author));

        } catch (AuthorExistException e) {
            e.printStackTrace();
            body.setMessage("Author with these parameters already exist.");
            body.setStatus(HttpStatus.BAD_REQUEST);
            response = ResponseEntity.badRequest().body(bodyMessageAssembler.getBodyJSON(body));

        } catch (IOException ex) {
            ex.printStackTrace();
            body.setMessage("Perhaps you applied wrong format data.");
            body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyMessageAssembler.getBodyJSON(body));
        }

        return response;
    }

    @RequestMapping(
            value="/{id}",
            method={RequestMethod.DELETE}
    )
    public ResponseEntity<String> deleteAuthor(@PathVariable(value="id") Long id) throws IOException {
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.DELETE)
                .setModel(Author.class)
                .build();

        try {
            authorService.removeAuthor(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
            body.setMessage(e.getMessage());
            body.setStatus(HttpStatus.NOT_FOUND);
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyMessageAssembler.getBodyJSON(body));
        }

        return response;
    }

    @RequestMapping(
            value="",
            method={RequestMethod.PUT},
            consumes="application/json",
            produces="application/json"
    )
    public ResponseEntity<String> updateAuthor(@RequestBody Author author) throws IOException {
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.PUT)
                .setModel(Author.class)
                .build();

        try {
            Author updatedAuthor = authorService.updateAuthor(author);
            response = ResponseEntity.ok(assembler.getModelObj(updatedAuthor));
        } catch (AuthorNotFoundException e) {
            e.printStackTrace();
            body.setMessage("Author does not exist.");
            body.setStatus(HttpStatus.NOT_FOUND);
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyMessageAssembler.getBodyJSON(body));
        } catch (IOException e) {
            e.printStackTrace();
            body.setMessage("Perhaps you applied wrong format data.");
            body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyMessageAssembler.getBodyJSON(body));
        }

        return response;
    }



}
