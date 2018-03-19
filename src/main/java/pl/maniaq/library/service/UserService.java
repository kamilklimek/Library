package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.UserDao;
import pl.maniaq.library.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public UserService(){

    }

    public boolean registerUser(User user){
        String userEmail = user.getEmail();
        boolean userExists = userDao.existsByEmail(userEmail);
        if(!userExists){
            userDao.save(user);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers(){
        return userDao.findAll();
    }

}
