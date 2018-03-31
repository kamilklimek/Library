package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.validation.CategoryValidation;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryValidation categoryValidation;

    public CategoryService(){

    }

    public boolean addNewCategory(Category category){
        boolean categoryExists = categoryValidation.validateCategoryExists(category.getCategoryName());

        if(!categoryExists){
            categoryDao.save(category);
            return true;
        }
        return false;
    }

    public List<Category> getAllCategories(){
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

}
