package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maniaq.library.model.User;

import javax.transaction.Transactional;


public interface UserDao extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
