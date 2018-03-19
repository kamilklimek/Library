package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.UserDao;
import pl.maniaq.library.model.User;
import pl.maniaq.library.validation.UserValidation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserValidation userValidation;

    public UserService(){

    }

    public boolean registerUser(User user){
        boolean userExists = userValidation.validateUserExists(user);
        if(!userExists){
            userDao.save(user);
            return true;
        }
        return false;
    }

    public Collection<User> getAllUsers(){
        Collection<User> users = new ArrayList<>();
        userDao.findAll().forEach(users::add);

        return users;
    }

}
