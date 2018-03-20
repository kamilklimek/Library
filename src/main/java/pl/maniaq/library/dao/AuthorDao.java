package pl.maniaq.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorDao extends JpaRepository<Author, Long> {

    Optional<Collection<Author>> getAuthorsByAuthorLastName(String lastName);
    Author getAuthorByAuthorLastNameAndAuthorName(String authorLastName, String authorName);
}
