import React from 'react';
import {addCategory} from "../../store/index.manager";
import {createCategory} from "../../api/category.repository";
import CategoriesForm from "../../components/forms/categoriesForm.component";

class CategoriesFormContainer extends React.Component {


    onCreateCategory(category) {
        console.log(category);

        return createCategory(category)
            .then(newCategory => addCategory(newCategory));
    }

    render() {
        return (
            <CategoriesForm handleActionCategory={(category) => this.onCreateCategory(category)} title="Add category"/>
        );
    }

}
export default CategoriesFormContainer;
