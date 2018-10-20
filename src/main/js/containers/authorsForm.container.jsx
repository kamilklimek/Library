import React from 'react';
import AuthorsForm from '../components/authorsForm.component';
import {createAuthor} from "../api/author.repository";
import {addAuthor} from "../store/index.manager";
import {prepareFetchAuthor} from "../utils/author.utils";
import validateAuthor from "../validation/validateAuthor";

class AuthorsFormContainer extends React.Component {


    onCreateNewAuthor(author) {

        if (!validateAuthor(author)) {
            return Promise.reject('Something goes wrong');
        }

        return createAuthor(author)
            .then(newAuthor => addAuthor(prepareFetchAuthor(newAuthor)));
    }

    render() {
        return (
            <AuthorsForm handleCreateAuthor={(author) => this.onCreateNewAuthor(author)} />
        );
    }

}
export default AuthorsFormContainer;
