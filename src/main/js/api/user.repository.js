function getBaseURL() {
    return 'http://localhost:10000';
}

export function registerUser(user) {
    return fetch(`${getBaseURL()}/user/register`, {
        method: 'POST',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(user),
    }).then(response => response.json())
    .catch(console.warn);
}

export function loginUser(user) {
    return fetch(`${getBaseURL()}/user/login`, {
        method: 'POST',
        headers: new Headers({'content-type': 'application/json'}),
        body: JSON.stringify(user),
    }).then(response => response.json())
    .catch(console.warn);
}
