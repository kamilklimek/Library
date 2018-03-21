package pl.maniaq.library;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.maniaq.library.dao.UserDao;
import pl.maniaq.library.model.User;
import pl.maniaq.library.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests{

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Test
    public void testRegisterUser(){
        String email = "TestJohn@test.com";
        User user = new User.UserBuilder()
                .setLogin("TestJohn")
                .setEmail(email)
                .setPassword("johnpassword")
                .createUser();

        userService.registerUser(user);

        User userFromRepository = userDao.findByEmail(email);
        Long userIdFromRepository = userFromRepository.getId();
        user.setId(userIdFromRepository);


        Assert.assertEquals(userFromRepository, user);
    }




}
