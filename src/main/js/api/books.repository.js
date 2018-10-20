import { prepareAuthorToSave } from "../utils/author.utils";

function getBaseURL() {
    return 'http://localhost:10000';
}

export function getBooks() {
    return fetch(`${getBaseURL()}/book`)
        .then(response => response.json())
        .catch(console.warn);
}

export function createBook(book) {
    return fetch(`${getBaseURL()}/book`, {
        method: 'POST',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(book),
    })
        .then(response => response.json())
        .catch(console.warn);
}
export function deleteBook(id) {
    return fetch(`${getBaseURL()}/book/${id}`, {
        method: 'DELETE',
        headers: new Headers({'content-type': 'application/json'}),
    })
        .then(response => response.json())
        .catch(console.warn);
}