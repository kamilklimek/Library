package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maniaq.library.model.Book;

import javax.transaction.Transactional;

public interface BookDao extends CrudRepository<Book, Long> {
    //Book findByTitle(String title);
    //Book findAllByAuthors(String authorName);
    //Book findAllByCategories(String categoryName);

}
