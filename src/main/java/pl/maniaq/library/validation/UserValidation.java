package pl.maniaq.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.UserDao;
import pl.maniaq.library.exceptions.UserNotFoundException;
import pl.maniaq.library.model.User;

@Component
public class UserValidation {

    @Autowired
    UserDao userDao;

    public UserValidation(){

    }

    public boolean validateUserExists(User user) throws UserNotFoundException {
        String userEmail = user.getEmail();
        boolean userExists = userDao.existsByEmail(userEmail);
        if(userExists)
            return true;

        return false;
        //throw new UserNotFoundException(userEmail);
    }



}
