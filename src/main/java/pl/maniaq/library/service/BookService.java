package pl.maniaq.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.dao.BookDao;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.exceptions.BookExistException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.validation.BookValidation;

import java.util.List;

@Service
public class BookService {

    private BookValidation bookValidation;
    private BookDao bookDao;
    private CategoryDao categoryDao;
    private AuthorDao authorDao;
    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(BookValidation bookValidation,
                       BookDao bookDao,
                       CategoryDao categoryDao,
                       AuthorDao authorDao){
        this.bookValidation = bookValidation;
        this.bookDao = bookDao;
        this.categoryDao=categoryDao;
        this.authorDao=authorDao;
    }

    public Book addNewBook(Book book) throws BookExistException {
        Author author = authorDao.getAuthorById(book.getAuthor().getId()).get();
        Category category = categoryDao.getCategoryById(book.getCategory().getId());

        boolean bookAlreadyExist = bookValidation.validateBookExists(book.getTitle(), author);

        if(!bookAlreadyExist){

            book.setAuthor(author);
            book.setCategory(category);

            Book createdBook = bookDao.save(book);
            logger.info("Create new object book.", createdBook);
            return createdBook;
        }


        logger.info("Error while add new book. Book already exist.");
        throw new BookExistException("Book already exists.");
    }

    public List<Book> getAllBooks(){
        return bookDao.findAll();
    }

}
