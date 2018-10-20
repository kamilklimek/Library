import store from "./index.store";
export function addAuthor(author) {
    store.dispatch({
        type: 'ADD_AUTHOR',
        author,
    });
}

export function setAuthors(authors) {
    store.dispatch({
        type: 'SET_AUTHORS',
        authors,
    });
}

export function addBook(book) {
    store.dispatch({
        type: 'ADD_BOOK',
        book,
    });
}

export function setBooks(books) {
    store.dispatch({
        type: 'SET_BOOKS',
        books,
    });
}
export function addCategory(category) {
    store.dispatch({
        type: 'ADD_CATEGORY',
        category,
    });
}

export function setCategories(categories) {
    store.dispatch({
        type: 'SET_CATEGORIES',
        categories,
    });
}

export function getBooksFromStore() {
    return store.getState().books;
}

export function removeBookFromStore(id) {
    store.dispatch({
        type: 'REMOVE_BOOK',
        id,
    });
}

export function removeCategoryFromStore(id) {
    store.dispatch({
        type: 'REMOVE_CATEGORY',
        id,
    });
}

export function getCategoriesFromStore() {
    return store.getState().categories;
}

export function getAuthorsFromStore() {
    return store.getState().authors;
}

export function removeAuthorFromStore(id) {
    store.dispatch({
        type: 'REMOVE_AUTHOR',
        id,
    });
}

export function editAuthor(author) {
    store.dispatch({
        type: 'EDIT_AUTHOR',
        author,
    });
}

export function editCategory(category) {
    store.dispatch({
        type: 'EDIT_CATEGORY',
        category,
    });
}

export function editBook(book) {
    store.dispatch({
        type: 'EDIT_BOOK',
        book,
    });
}


