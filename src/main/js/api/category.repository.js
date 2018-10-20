function getBaseURL() {
    return 'http://localhost:10000';
}

export function getCategories() {
    return fetch(`${getBaseURL()}/category`)
        .then(response => response.json())
        .catch(console.warn);
}

export function createCategory(category) {
    return fetch(`${getBaseURL()}/category`, {
        method: 'POST',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(category),
    })
        .then(response => response.json())
        .catch(console.warn);
}

export function deleteCategory(id) {
    return fetch(`${getBaseURL()}/category/${id}`, {
        method: 'DELETE',
        headers: new Headers({'content-type': 'application/json'}),
    })
        .then(response => response.json())
        .catch(console.warn);
}

export function updateCategory(category) {
    return fetch(`${getBaseURL()}/category/`, {
        method: 'PUT',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(category),
    })
        .then(response => response.json())
        .catch(console.warn);
}