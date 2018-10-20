package pl.maniaq.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.Book;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BookDao extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findAllByAuthor(String authorName);
    Book findAllByCategory(String categoryName);
    Optional<Book> getBookById(Long id);

    boolean existsBookByTitleAndAuthor(String title, Author author);
    boolean existsBookById(Long id);

    void deleteBookById(Long id);
}
