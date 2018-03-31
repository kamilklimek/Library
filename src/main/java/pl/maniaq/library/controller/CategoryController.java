package pl.maniaq.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.service.CategoryService;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController(){

    }

    @RequestMapping(
            value="",
            method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();

        return categories;
    }

    @RequestMapping(
            value="",
            method = RequestMethod.POST)
    public String addNewCategory(
            @RequestParam String categoryName,
            @RequestParam String categoryDescription){
        Category category = new Category(categoryName, categoryDescription);

        return categoryService.addNewCategory(category) ? "Ok" : "Error.";

    }
}
