package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.validation.AuthorValidation;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    AuthorValidation authorValidation;

    public AuthorService(){

    }

    public boolean addNewAuthor(Author author){
        boolean authorAlreadyExist = authorValidation.validateAuthorExists(author.getAuthorName(), author.getAuthorLastName());

        if(!authorAlreadyExist){
            authorDao.save(author);
            return true;
        }

        return false;
    }

}
