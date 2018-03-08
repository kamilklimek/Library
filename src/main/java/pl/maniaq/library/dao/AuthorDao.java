package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.Author;

public interface AuthorDao extends CrudRepository<Long, Author> {
}
