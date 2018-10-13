package pl.maniaq.library.errors;


import pl.maniaq.library.model.enums.CrudOperations;

public class ModelError {

    private String error;
    private String message;
    private CrudOperations operation;

    public ModelError(Class<?> classError, String message, CrudOperations operation) {
        this.error = classError.getTypeName();
        this.message = message;
        this.operation=operation;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public CrudOperations getOperation() {
        return operation;
    }
}

