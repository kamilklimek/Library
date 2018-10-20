import {getAuthorsFromStore} from "../store/index.manager";

export default function getAuthorById(id) {
    return getAuthorsFromStore().find(book => book.id === id);
}