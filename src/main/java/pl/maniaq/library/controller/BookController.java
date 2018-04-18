package pl.maniaq.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.service.AuthorService;
import pl.maniaq.library.service.BookService;
import pl.maniaq.library.service.CategoryService;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/books")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired

    public BookController(){

    }

    @RequestMapping(
            value="",
            method = RequestMethod.POST)
    public String addNewBook(
            @RequestParam(value="title") String bookTitle,
            @RequestParam(value="description") String bookDescription,
            @RequestParam(value="releaseYear") String releaseYear,
            @RequestParam(value="categoryId") Long categoryId,
            @RequestParam(value="authorId") Long authorId){


        Book book = new Book.BookBuilder()
                .setTitle(bookTitle)
                .setDescription(bookDescription)
                .setReleaseYear(Integer.parseInt(releaseYear))
                .setAuthorId(authorId)
                .setCategoryId(categoryId)
                .createBook();

        return bookService.addNewBook(book) ? "Ok." : "False";
    }

    @RequestMapping(
            value="/list",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public List<Book> getAllBooks(){
        List<Book> books = bookService.getAllBooks();

        return books;

    }


}
