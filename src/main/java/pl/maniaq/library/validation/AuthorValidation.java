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

    public boolean validateAuthorExists(String authorName, String authorLastName){
        boolean authorsListIsNotEmpty = authorDao.getAuthorsByAuthorLastName(authorLastName).isPresent();

        if(authorsListIsNotEmpty){
            Collection<Author> authors = authorDao.getAuthorsByAuthorLastName(authorLastName).get();

            for (Author author: authors
                 ) {
                boolean authorNameEquals = Objects.equals(authorName, author.getAuthorName());
                if(authorNameEquals){
                    return true;
                }
            }

        }

        return false;

    }

}