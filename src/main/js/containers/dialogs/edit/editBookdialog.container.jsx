import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import getBookById from "../../../services/books.service";
import {editBook, getAuthorsFromStore, getCategoriesFromStore} from "../../../store/index.manager";
import Modal from "react-modal";
import BooksForm from "../../../components/forms/booksForm.component";
import {updateBook} from "../../../api/books.repository";

class EditBookDialogContainer extends React.Component {
    static openDialog(id) {
        ReactDOM.render(
            <EditBookDialogContainer book={getBookById(id)}/>
            , document.getElementById('modalContainer')
        );
    }

    static closeDialog() {
        ReactDOM.unmountComponentAtNode(document.getElementById('modalContainer'));
    }


    constructor(props) {
        super(props);

        this.customStyles = {
            content : {
                top                   : '50%',
                left                  : '50%',
                right                 : 'auto',
                bottom                : 'auto',
                marginRight           : '-50%',
                transform             : 'translate(-50%, -50%)',
                width                 : '50%',
                maxHeight             : '75%',
            }
        };

        this.state = {
            modalIsOpen: true,
        }
    }

    onEditBook(book) {
        console.log('book', book);
        return updateBook(book)
            .then(updatedBook => editBook(updatedBook))
            .then(EditBookDialogContainer.closeDialog);
    }

    render() {
        console.log(this.props.book);
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove book"
            >

                <BooksForm
                    handleActionBook={(book) => this.onEditBook(book)}
                    title="Edit book"
                    book={this.props.book}
                    isEditMode
                    categories={getCategoriesFromStore()}
                    authors={getAuthorsFromStore()}
                />

            </Modal>
        )
    }

}

EditBookDialogContainer.propTypes = {
    book: PropTypes.object.isRequired,
};

export default EditBookDialogContainer;