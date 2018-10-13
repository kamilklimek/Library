package pl.maniaq.library.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.exceptions.BookExistException;
import pl.maniaq.library.exceptions.CategoryExistException;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.validation.CategoryValidation;

import java.util.List;

@Service
public class CategoryService {

    CategoryDao categoryDao;
    CategoryValidation categoryValidation;
    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    public CategoryService(CategoryDao categoryDao,
                           CategoryValidation categoryValidation){
        this.categoryDao = categoryDao;
        this.categoryValidation = categoryValidation;
    }

    public Category addNewCategory(Category category) throws CategoryExistException {
        boolean categoryExists = categoryValidation.validateCategoryExists(category.getCategoryName());

        if(!categoryExists){
            Category createdCategory = categoryDao.save(category);
            logger.info("Create new object author.", createdCategory);
            return createdCategory;
        }

        logger.warn("Category with this name already exist.", category);
        throw new CategoryExistException("Category with name: " + category.getCategoryName() + " already exist.");
    }

    public List<Category> getAllCategories(){
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

}
