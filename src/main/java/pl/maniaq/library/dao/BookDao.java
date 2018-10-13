package pl.maniaq.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.model.Book;

import javax.transaction.Transactional;

public interface BookDao extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findAllByAuthor(String authorName);
    Book findAllByCategory(String categoryName);

    boolean existsByTitleAndAuthor(String title, Author author);
    boolean existsById(Long id);

}
