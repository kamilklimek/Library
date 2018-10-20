import moment from 'moment';

export function prepareAuthorToSave(author) {
    return { ...author, bornDate: moment(author.bornDate).format("YYYY-MM-DD")};
}

export function prepareFetchAuthor(author) {
    return { ...author, bornDate: moment(author.bornDate).format("YYYY-MM-DD") };
}

export function prepareFetchAuthors(authors) {
    return authors.map(author => prepareFetchAuthor(author));
}
