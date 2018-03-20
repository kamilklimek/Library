package pl.maniaq.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maniaq.library.dao.CategoryDao;
import pl.maniaq.library.model.Category;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public CategoryService(){

    }

    public boolean addNewCategory(Category category){
        boolean
    }

}
