package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.exceptions.AuthorExistException;
import pl.maniaq.library.exceptions.AuthorNotFoundException;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.validation.AuthorValidation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorValidation authorValidation;
    AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorValidation authorValidation,
                         AuthorDao authorDao){
        this.authorValidation = authorValidation;
        this.authorDao = authorDao;
    }

    public Optional<Author> addNewAuthor(Author author) throws AuthorExistException {
        boolean authorAlreadyNoExist = !authorValidation.validateAuthorExists(author.getAuthorName(), author.getAuthorLastName());

        if(authorAlreadyNoExist){
            return Optional.of(authorDao.save(author));
        }

        throw new AuthorExistException("Author with name: " + author.getAuthorName() + " and lastname: " + author.getAuthorLastName() + " does not exist.");
    }

    public void removeAuthor(Long authorId) throws AuthorNotFoundException {
        if(authorValidation.validateAuthorExists(authorId)){
            authorDao.deleteById(authorId);
        }
    }

    public boolean updateAuthor(Author author) throws AuthorNotFoundException {
        String name = author.getAuthorName();
        String lastName = author.getAuthorLastName();

        if(authorValidation.validateAuthorExists(name, lastName)){
            Author authorFromRepository = authorDao.getAuthorByAuthorNameAndAuthorLastName(name, lastName);
            Long authorIdFromRepository = authorFromRepository.getId();

            author.setId(authorIdFromRepository);
            authorFromRepository = author;

            authorDao.flush();
            return true;
        }

        throw new AuthorNotFoundException("Author with id: " + author.id + " does not exist.");

    }

    public List<Author> getAllAuthors(){

        return authorDao.findAll();
    }

}
