package pl.maniaq.library.model.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.model.BodyMessage;
import pl.maniaq.library.wrappers.ObjectMapperWrapper;

import java.io.IOException;

@Component
public class BodyMessageAssembler {

    private ObjectMapperWrapper objectMapperWrapper;

    @Autowired
    public BodyMessageAssembler(ObjectMapperWrapper objectMapperWrapper) {
        this.objectMapperWrapper=objectMapperWrapper;
    }

    public String getBodyJSON(BodyMessage modelError) throws IOException {
        return objectMapperWrapper.writeValueAsString(modelError);
    }
}
