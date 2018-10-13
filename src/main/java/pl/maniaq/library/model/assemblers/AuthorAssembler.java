package pl.maniaq.library.model.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.model.Author;
import pl.maniaq.library.wrappers.ObjectMapperWrapper;

import java.io.IOException;

@Component
public class AuthorAssembler {

    private ObjectMapperWrapper objectMapperWrapper;

    @Autowired
    public AuthorAssembler(ObjectMapperWrapper objectMapperWrapper) {
        this.objectMapperWrapper=objectMapperWrapper;
    }


    public String getAuthorJSON(Author author) throws IOException {
        return objectMapperWrapper.writeValueAsString(author);
    }
}
