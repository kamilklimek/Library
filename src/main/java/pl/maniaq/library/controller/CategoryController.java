package pl.maniaq.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maniaq.library.exceptions.BookExistException;
import pl.maniaq.library.exceptions.CategoryExistException;
import pl.maniaq.library.model.BodyMessage;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.model.Category;
import pl.maniaq.library.model.assemblers.BodyMessageAssembler;
import pl.maniaq.library.model.assemblers.ModelAssembler;
import pl.maniaq.library.model.enums.CrudOperations;
import pl.maniaq.library.service.CategoryService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/category")
public class CategoryController {

    private CategoryService categoryService;
    private ModelAssembler assembler;
    private BodyMessageAssembler bodyMessageAssembler;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              ModelAssembler assembler,
                              BodyMessageAssembler bodyMessageAssembler){
        this.categoryService  = categoryService;
        this.assembler=assembler;
        this.bodyMessageAssembler = bodyMessageAssembler;
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
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json"
    )
    public ResponseEntity<String> createCategory(@RequestBody Category category) throws IOException {
        ResponseEntity<String> response;
        BodyMessage body = new BodyMessage.Builder()
                .setOperation(CrudOperations.CREATE)
                .setModel(Category.class)
                .build();

        try {
            category = categoryService.addNewCategory(category);
            response = ResponseEntity.ok(assembler.getModelObj(category));

        } catch (CategoryExistException e) {
            e.printStackTrace();
            body.setMessage("Category with these parameters already exist.");
            body.setStatus(HttpStatus.BAD_REQUEST);
            response = ResponseEntity.badRequest().body(bodyMessageAssembler.getBodyJSON(body));

        } catch (IOException ex) {
            ex.printStackTrace();
            body.setMessage("Perhaps you applied wrong format data.");
            body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyMessageAssembler.getBodyJSON(body));
        }

        return response;
    }
}
