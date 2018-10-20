import {getBooksFromStore} from "../store/index.manager";

export default function getBookById(id) {
    return getBooksFromStore().find(book => book.id === id);
}