package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.Book;

public interface BookDao extends CrudRepository<Long, Book> {
    Book findByTitle(String title);
    Book findAllByAuthors(String authorName);
    Book findAllByCategories(String categoryName);

}
