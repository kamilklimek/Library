package pl.maniaq.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    public AuthorService(AuthorValidation authorValidation,
                         AuthorDao authorDao){
        this.authorValidation = authorValidation;
        this.authorDao = authorDao;
    }

    public Optional<Author> addNewAuthor(Author author) throws AuthorExistException {
        boolean authorAlreadyNoExist = !authorValidation.validateAuthorExists(author.getAuthorName(), author.getAuthorLastName());

        if(authorAlreadyNoExist){
            Author createdAuthor = authorDao.save(author);
            logger.info("Create new object author.", createdAuthor);
            return Optional.of(createdAuthor);
        }

        logger.warn("Author with these name and lastname already exist.", author);
        throw new AuthorExistException("Author with name: " + author.getAuthorName() + " and lastname: " + author.getAuthorLastName() + " already exist.");
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

        logger.warn("Author with with given id already exist.", author);
        throw new AuthorNotFoundException("Author with id: " + author.id + " does not exist.");
    }

    public List<Author> getAllAuthors(){

        return authorDao.findAll();
    }

}
