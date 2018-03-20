package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.BookDao;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.validation.BookValidation;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookValidation bookValidation;


    public BookService(){
    }

    public boolean addNewBook(Book book){
        bookDao.save(book);
        return true;
    }

    public Collection<Book> getAllBooks(){
        return bookDao.findAll();
    }

}
