package pl.maniaq.library.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.CategoryDao;

@Component
public class CategoryValidation {

    @Autowired
    CategoryDao categoryDao;

    public CategoryValidation(){

    }

    public boolean validateCategoryExists(String categoryName){
        boolean categoryExists = categoryDao.existsCategoryByCategoryName(categoryName);

        if(categoryExists){
           return true;
        }

        return false;
    }

}
