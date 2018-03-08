package pl.maniaq.library.dao;

import org.springframework.data.repository.CrudRepository;
import pl.maniaq.library.model.Category;

public interface CategoryDao extends CrudRepository<Long, Category> {
}
