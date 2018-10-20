import React from 'react';
import {connect} from 'react-redux';
import {addBook} from "../../store/index.manager";
import BooksForm from "../../components/forms/booksForm.component";
import {createBook} from "../../api/books.repository";

class BooksFormContainer extends React.Component {
    onCreateBook(book) {
        console.log('Book', book);
        return createBook(book)
            .then(newBook => addBook(newBook));
    }

    render() {
        return (
            <BooksForm handleCreateBook={(book) => this.onCreateBook(book)} authors={this.props.authors} categories={this.props.categories} />
        );
    }

}

const mapStateToProps = function(store) {
    return {
        authors: store.authors,
        categories: store.categories,
    };
};
export default connect(mapStateToProps)(BooksFormContainer);
