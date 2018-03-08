package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.Book;

public interface BookDao extends CrudRepository<Long, Book> {
}
