package pl.maniaq.library.model.assemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maniaq.library.wrappers.ObjectMapperWrapper;

import java.io.IOException;

@Component
public class ModelAssembler {

    private ObjectMapperWrapper objectMapperWrapper;

    @Autowired
    public ModelAssembler(ObjectMapperWrapper objectMapperWrapper) {
        this.objectMapperWrapper=objectMapperWrapper;
    }


    public String getModelObj(Object obj) throws IOException {
        return objectMapperWrapper.writeValueAsString(obj);
    }
}
