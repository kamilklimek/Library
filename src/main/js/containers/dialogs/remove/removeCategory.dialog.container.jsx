import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import Modal from 'react-modal';
import {Button, ButtonGroup} from "react-bootstrap";
import getCategoryById from "../../../services/categories.service";
import {removeCategoryFromStore} from "../../../store/index.manager";
import {deleteCategory} from "../../../api/category.repository";

class RemoveCategoryDialogContainer extends React.Component {

    static openDialog(id) {
        ReactDOM.render(
            <RemoveCategoryDialogContainer category={getCategoryById(id)}/>
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

    handleRemoveCategory() {
        const { id } = this.props.category;
        deleteCategory(id)
            .then(() => removeCategoryFromStore(id))
            .then(RemoveCategoryDialogContainer.closeDialog)
            .catch(console.warn);
    }

    render() {
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove category"
            >

                <h2 className="title title-remove">Remove category</h2>
                <p>{`Are you sure you want to category ${this.props.category.categoryName} and all books assigned to this category?`}</p>
                <ButtonGroup className="remove-buttons">
                    <Button type="submit" bsStyle="danger" onClick={() => this.handleRemoveCategory()}>Remove</Button>
                    <Button type="submit" onClick={RemoveCategoryDialogContainer.closeDialog}>Close</Button>
                </ButtonGroup>

            </Modal>
        )
    }

}

RemoveCategoryDialogContainer.propTypes = {
    category: PropTypes.object.isRequired,
};

export default RemoveCategoryDialogContainer;