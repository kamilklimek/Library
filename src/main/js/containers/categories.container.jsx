import React, {Component} from 'react';
import connect from "react-redux/es/connect/connect";
import CategoriesTable from "../components/tables/categoriesTable.component";
import CategoriesFormContainer from "./forms/categoriesForm.container";


class CategoriesContainer extends Component {
    render() {
        return (
            <div className="authors__container">
                <CategoriesTable categories={this.props.categories} />
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
