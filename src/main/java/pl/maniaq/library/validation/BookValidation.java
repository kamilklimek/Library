package pl.maniaq.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.dao.BookDao;
import pl.maniaq.library.model.Author;

@Component
public class BookValidation {

    private BookDao bookDao;

    @Autowired
    public BookValidation(BookDao bookDao){
        this.bookDao = bookDao;
    }

    public boolean validateBookExists(Long bookId) {
        return bookDao.existsBookById(bookId);
    }

    public boolean validateBookExists(String title, Author author) {
        return bookDao.existsBookByTitleAndAuthor(title, author);
    }

}