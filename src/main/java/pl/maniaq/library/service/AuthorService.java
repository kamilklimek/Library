package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.validation.AuthorValidation;

import java.util.Collection;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    AuthorValidation authorValidation;

    public AuthorService(){

    }

    public boolean addNewAuthor(Author author){
        String name = author.getAuthorName();
        String lastname = author.getAuthorLastName();

        boolean authorAlreadyExist = authorValidation.validateAuthorExists(name, lastname);

        if(!authorAlreadyExist){
            authorDao.save(author);
            return true;
        }

        return false;
    }

    public boolean removeAuthor(Long authorId){
        boolean authorAlreadyExist = authorValidation.validateAuthorExists(authorId);

        if(authorAlreadyExist){
            authorDao.deleteById(authorId);
            return true;
        }

        return false;
    }

    public boolean updateAuthor(Author author){
        String name = author.getAuthorName();
        String lastname = author.getAuthorLastName();

        boolean authorAlreadyExist = authorValidation.validateAuthorExists(name, lastname);

        if(authorAlreadyExist){
            Author authorFromRepository = authorDao.getAuthorByAuthorNameAndAuthorLastName(name, lastname);
            Long authorIdFromRepository = authorFromRepository.getId();

            author.setId(authorIdFromRepository);
            authorFromRepository = author;

            authorDao.flush();
            return true;
        }

        return false;
    }

    public Collection<Author> getAllAuthors(){
        return authorDao.findAll();
    }

}
