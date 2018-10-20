import store from "./index.store";

export function getAuthors() {
    console.log(store.getState());
    return store.getState().authors;
}

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

