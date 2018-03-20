package pl.maniaq.library.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.dao.BookDao;

@Component
public class BookValidation {

    @Autowired
    BookDao bookDao;

    public BookValidation(){

    }

    public boolean validateBookExists(){
        return true;
    }

}
