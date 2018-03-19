package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.maniaq.library.dao.UserDao;
import pl.maniaq.library.model.User;

public class UserService {

    @Autowired
    UserDao userDao;

    public boolean registerUser(User user){
        String userEmail = user.getEmail();
        boolean userExists = userDao.existsByEmail(userEmail);
        if(!userExists){
            userDao.save(user);
        }
        return false;
    }

}
