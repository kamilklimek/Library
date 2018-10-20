import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import getAuthorById from "../../../services/authors.service";
import AuthorsForm from "../../../components/forms/authorsForm.component";
import {editAuthor} from "../../../store/index.manager";
import Modal from "react-modal";
import {updateAuthor} from "../../../api/author.repository";
import {prepareFetchAuthor} from "../../../utils/author.utils";

class EditAuthorDialogContainer extends React.Component {

    static openDialog(id) {
        ReactDOM.render(
            <EditAuthorDialogContainer author={getAuthorById(id)}/>
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

    onEditAuthor(author) {
        console.log('author', author);
        return updateAuthor(author)
            .then(updatedAuthor => editAuthor(prepareFetchAuthor(updatedAuthor)))
            .then(EditAuthorDialogContainer.closeDialog);
    }

    render() {
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove book"
            >

                <AuthorsForm
                    handleActionAuthor={(author) => this.onEditAuthor(author)}
                    title="Edit author"
                    author={({ ...this.props.author, bornDate: new Date(this.props.author.bornDate) })}
                    isEditMode
                />

            </Modal>
        )
    }

}

EditAuthorDialogContainer.propTypes = {
    author: PropTypes.object.isRequired,
};

export default EditAuthorDialogContainer;