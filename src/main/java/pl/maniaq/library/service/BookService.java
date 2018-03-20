package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.BookDao;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.validation.BookValidation;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookValidation bookValidation;


    public BookService(){
    }

    public boolean addNewBook(Book book){
        boolean bookExists = bookValidation.validateBookExists();

        if(!bookExists){
            bookDao.save(book);
            return true;
        }

        return false;

    }

}
