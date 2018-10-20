import { prepareAuthorToSave } from "../utils/author.utils";

function getBaseURL() {
    return 'http://localhost:10000';
}

export function getAuthors() {
    return fetch(`${getBaseURL()}/author`)
        .then(response => response.json())
        .catch(console.warn);
}

export function createAuthor(author) {
    return fetch(`${getBaseURL()}/author`, {
        method: 'POST',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(prepareAuthorToSave(author)),
    })
        .then(response => response.json())
        .catch(console.warn);
}

export function deleteAuthor(id) {
    return fetch(`${getBaseURL()}/author/${id}`, {
        method: 'DELETE',
        headers: new Headers({'content-type': 'application/json'}),
    })
        .then(response => response.json())
        .catch(console.warn);
}