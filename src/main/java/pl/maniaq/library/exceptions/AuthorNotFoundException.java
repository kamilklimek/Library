package pl.maniaq.library.exceptions;

import pl.maniaq.library.model.Author;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
