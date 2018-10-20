import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import Modal from 'react-modal';
import {Button, ButtonGroup} from "react-bootstrap";
import getAuthorById from "../../services/authors.service";
import {deleteAuthor} from "../../api/author.repository";
import {removeAuthorFromStore} from "../../store/index.manager";

class RemoveAuthorDialogContainer extends React.Component {

    static openDialog(id) {
        ReactDOM.render(
            <RemoveAuthorDialogContainer author={getAuthorById(id)}/>
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

    handleRemoveAuthor() {
        const { id } = this.props.author;
        deleteAuthor(id)
            .then(() => removeAuthorFromStore(id))
            .then(RemoveAuthorDialogContainer.closeDialog)
            .catch(console.warn);
    }

    render() {
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove author"
            >

                <h2 className="title title-remove">Remove author</h2>
                <p>{`Are you sure you want to category ${this.props.author.authorLastName} and all books assigned to this author?`}</p>
                <ButtonGroup className="remove-buttons">
                    <Button type="submit" bsStyle="danger" onClick={() => this.handleRemoveAuthor()}>Remove</Button>
                    <Button type="submit" onClick={RemoveAuthorDialogContainer.closeDialog}>Close</Button>
                </ButtonGroup>

            </Modal>
        )
    }

}

RemoveAuthorDialogContainer.propTypes = {
    author: PropTypes.object.isRequired,
};

export default RemoveAuthorDialogContainer;