package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.User;

public interface UserDao extends CrudRepository<Long, User> {
    User findByEmail(String email);
}
