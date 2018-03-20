package pl.maniaq.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.service.BookService;

import java.util.Collection;

@RestController
@RequestMapping(value="/books/")
public class BookController {

    @Autowired
    BookService bookService;

    public BookController(){

    }

    @RequestMapping(
            value="/",
            method = RequestMethod.POST)
    public String addNewBook(
            @RequestParam String bookTitle,
            @RequestParam String bookDescription,
            @RequestParam String releaseYear){

        Book book = new Book(bookTitle, bookDescription, Integer.parseInt(releaseYear));

        return  bookService.addNewBook(book) ? "Ok." : "False";
    }

    @RequestMapping(
            value="/",
            method = RequestMethod.GET)
    public Collection<Book> getAllBooks(){
        Collection<Book> books = bookService.getAllBooks();

        return books;

    }

}
