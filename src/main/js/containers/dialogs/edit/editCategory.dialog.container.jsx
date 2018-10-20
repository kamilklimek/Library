import React from 'react';
import ReactDOM from 'react-dom';
import PropTypes from 'prop-types';
import getCategoryById from "../../../services/categories.service";
import {editCategory} from "../../../store/index.manager";
import Modal from "react-modal";
import {updateCategory} from "../../../api/category.repository";
import CategoriesForm from "../../../components/forms/categoriesForm.component";

class EditCategoryDialogContainer extends React.Component {

    static openDialog(id) {
        console.log(getCategoryById(id));
        ReactDOM.render(
            <EditCategoryDialogContainer category={getCategoryById(id)}/>
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

    onEditCategory(category) {
        console.log('category', category);
        return updateCategory(category)
            .then(updatedCategory => editCategory(updatedCategory))
            .then(EditCategoryDialogContainer.closeDialog);
    }

    render() {
        Modal.setAppElement('#modalContainer');
        return (
            <Modal
                isOpen={this.state.modalIsOpen}
                style={this.customStyles}
                contentLabel="Remove book"
            >

                <CategoriesForm
                    handleActionCategory={(category) => this.onEditCategory(category)}
                    title="Edit category"
                    category={this.props.category}
                    isEditMode
                />

            </Modal>
        )
    }

}

EditCategoryDialogContainer.propTypes = {
    category: PropTypes.object.isRequired,
};

export default EditCategoryDialogContainer;