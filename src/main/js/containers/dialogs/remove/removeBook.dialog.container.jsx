import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import Modal from 'react-modal';
import {Button, ButtonGroup} from "react-bootstrap";
import getBookById from "../../../services/books.service";
import {deleteBook} from "../../../api/books.repository";
import {removeBookFromStore} from "../../../store/index.manager";

class RemoveBookDialogContainer extends React.Component {

    static openDialog(id) {
        ReactDOM.render(
            <RemoveBookDialogContainer book={getBookById(id)}/>
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
            }
        };

        this.state = {
            modalIsOpen: true,
        }
    }

    handleRemoveBook() {
        const { id } = this.props.book;
        deleteBook(id)
            .then(() => removeBookFromStore(id))
            .then(RemoveBookDialogContainer.closeDialog)
            .catch(console.warn);
    }

    render() {
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove book"
            >

                <h2 className="title title-remove">Remove book</h2>
                <p>{`Are you sure you want to remove book ${this.props.book.title}?`}</p>
                <ButtonGroup className="remove-buttons">
                    <Button type="submit" bsStyle="danger" onClick={() => this.handleRemoveBook()}>Remove</Button>
                    <Button type="submit" onClick={RemoveBookDialogContainer.closeDialog}>Close</Button>
                </ButtonGroup>

            </Modal>
        )
    }

}

RemoveBookDialogContainer.propTypes = {
    book: PropTypes.object.isRequired,
};

export default RemoveBookDialogContainer;