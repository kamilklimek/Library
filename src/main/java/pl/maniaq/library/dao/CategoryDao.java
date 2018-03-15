package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maniaq.library.model.Category;

import javax.transaction.Transactional;


public interface CategoryDao extends CrudRepository<Category, Long> {
}
