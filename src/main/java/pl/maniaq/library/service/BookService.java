package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.dao.BookDao;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.validation.BookValidation;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookValidation bookValidation;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    CategoryDao categoryDao;


    public BookService(){
    }

    public boolean addNewBook(Book book){
        Author author = authorDao.getAuthorById(book.getAuthor().getId()).get();
        Category category = categoryDao.getCategoryById(book.getCategory().getId());

        book.setAuthor(author);
        book.setCategory(category);

        bookDao.save(book);
        return true;
    }

    public List<Book> getAllBooks(){
        return bookDao.findAll();
    }

}
