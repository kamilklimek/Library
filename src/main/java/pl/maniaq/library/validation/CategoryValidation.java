package pl.maniaq.library.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.CategoryDao;

@Component
public class CategoryValidation {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryValidation(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

    public boolean validateCategoryExists(String categoryName) {
        return categoryDao.existsCategoryByCategoryName(categoryName);
    }

    public  boolean validateCategoryExists(Long id) {
        return categoryDao.existsById(id);
    }

}
