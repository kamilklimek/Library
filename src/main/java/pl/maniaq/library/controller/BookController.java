package pl.maniaq.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.exceptions.AuthorExistException;
import pl.maniaq.library.exceptions.AuthorNotFoundException;
import pl.maniaq.library.exceptions.BookExistException;
import pl.maniaq.library.exceptions.BookNotFoundException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.BodyMessage;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.model.assemblers.BodyMessageAssembler;
import pl.maniaq.library.model.assemblers.ModelAssembler;
import pl.maniaq.library.model.enums.CrudOperations;
import pl.maniaq.library.service.BookService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/book")
public class BookController {


    private BookService bookService;
    private ModelAssembler assembler;
    private BodyMessageAssembler bodyMessageAssembler;

    @Autowired
    public BookController(BookService bookService,
                          ModelAssembler assembler,
                            BodyMessageAssembler bodyMessageAssembler){
        this.bookService=bookService;
        this.assembler=assembler;
        this.bodyMessageAssembler = bodyMessageAssembler;
    }

    @RequestMapping(
            value="",
            method= RequestMethod.GET)
    public List<Book> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    @RequestMapping(
            value="",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json"
    )
    public ResponseEntity<String> createBook(@RequestBody Book book) throws IOException {
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.CREATE)
                .setModel(Book.class)
                .build();

        try {
            book = bookService.addNewBook(book);
            response = ResponseEntity.ok(assembler.getModelObj(book));

        } catch (BookExistException e) {
            e.printStackTrace();
            body.setMessage("Book with these parameters already exist.");
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
    public ResponseEntity<String> deleteBook(@PathVariable(value="id") Long id) throws IOException {
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.DELETE)
                .setModel(Book.class)
                .build();

        try {
            bookService.removeBook(id);
            response = ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (BookNotFoundException e) {
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
    public ResponseEntity<String> updateBook(@RequestBody Book book) throws IOException {
        System.out.println("Book: " + book.toString());
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.PUT)
                .setModel(Book.class)
                .build();

        try {
            book = bookService.updateBook(book);
            response = ResponseEntity.ok(assembler.getModelObj(book));
        } catch (BookNotFoundException e) {
            e.printStackTrace();
            body.setMessage("Book does not exist.");
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
