import React from 'react';
import {addCategory} from "../../store/index.manager";
import {createCategory} from "../../api/category.repository";
import CategoriesForm from "../../components/forms/categoriesForm.component";

class AuthorsFormContainer extends React.Component {


    onCreateCategory(category) {
        console.log(category);

        return createCategory(category)
            .then(newCategory => addCategory(newCategory));
    }

    render() {
        return (
            <CategoriesForm handleCreateCategory={(category) => this.onCreateCategory(category)} />
        );
    }

}
export default AuthorsFormContainer;
