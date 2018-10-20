import moment from 'moment';

export default function validateAuthor(author) {
    if (author.authorName.length === 0) {
        return false;
    }

    if (author.authorLastName.length === 0) {
        return false;
    }

    if (moment(author.bornDate).isAfter(moment())) {
        return false;
    }

    return true;
}