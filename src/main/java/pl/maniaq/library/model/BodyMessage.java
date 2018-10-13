package pl.maniaq.library.model;


import org.springframework.http.HttpStatus;
import pl.maniaq.library.model.enums.CrudOperations;

public class BodyMessage {

    private String model;
    private String message;
    private CrudOperations operation;
    private HttpStatus status;

    public BodyMessage(String className, String message, CrudOperations operation, HttpStatus status) {
        this.model = className;
        this.message = message;
        this.operation=operation;
        this.status=status;
    }

    public String getModel() {
        return model;
    }

    public String getMessage() {
        return message;
    }

    public CrudOperations getOperation() {
        return operation;
    }

    public static class Builder {
        private String model;
        private String message;
        private CrudOperations operation;    private HttpStatus status;


        public Builder() {

        }

        public Builder setModel(Class<?> model) {
            this.model = model.getName();
            return this;
        }

        public Builder setMessage(String message) {
            this.message=message;
            return this;
        }

        public Builder setOperation(CrudOperations operation) {
            this.operation=operation;
            return this;
        }

        public Builder setHttpStatus(HttpStatus status) {
            this.status=status;
            return this;
        }

        public BodyMessage build() {
            return new BodyMessage(model, message, operation, status);
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOperation(CrudOperations operation) {
        this.operation = operation;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

