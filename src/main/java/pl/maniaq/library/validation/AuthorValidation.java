package pl.maniaq.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.AuthorDao;
import pl.maniaq.library.model.Author;

import java.util.Collection;
import java.util.Objects;

@Component
public class AuthorValidation {

    @Autowired
    AuthorDao authorDao;

    public AuthorValidation(){

    }

    public boolean validateAuthorExists(Long authorId){
        boolean authorExists = authorDao.getAuthorById(authorId).isPresent();

        return authorExists ? true : false;
    }

    public boolean validateAuthorExists(String name, String lastname){
        boolean authorsExists = authorDao.existsAuthorByAuthorNameAndAuthorLastName(name, lastname);

        return authorsExists ? true : false;
    }

}