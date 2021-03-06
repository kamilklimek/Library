import React, {Component} from 'react';
import connect from "react-redux/es/connect/connect";
import CategoriesTable from "../components/tables/categoriesTable.component";
import CategoriesFormContainer from "./forms/categoriesForm.container";
import RemoveCategoryDialogContainer from "./dialogs/remove/removeCategory.dialog.container";
import EditCategoryDialogContainer from "./dialogs/edit/editCategory.dialog.container";


class CategoriesContainer extends Component {
    removeCategory(id) {
        RemoveCategoryDialogContainer.openDialog(id);
    }

    editCategory(id) {
        EditCategoryDialogContainer.openDialog(id);
    }

    render() {
        return (
            <div className="authors__container">
                <CategoriesTable categories={this.props.categories} onRemoveCategory={this.removeCategory} onEditCategory={this.editCategory}/>
                <CategoriesFormContainer />
            </div>
        );
    }
}

const mapStateToProps = function(store) {
    return {
        categories: store.categories,
    };
};

export default connect(mapStateToProps)(CategoriesContainer);
