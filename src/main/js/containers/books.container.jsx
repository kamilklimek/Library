import React, {Component} from 'react';
import connect from "react-redux/es/connect/connect";
import BooksFormContainer from "./forms/booksForm.container";
import BooksTable from "../components/tables/booksTable.component";

class BooksContainer extends Component {
    render() {
        return (
            <div className="authors__container">
                <BooksTable books={this.props.books} />
                <BooksFormContainer />
            </div>
        );
    }
}

const mapStateToProps = function(store) {
    return {
        books: store.books,
    };
};

export default connect(mapStateToProps)(BooksContainer);
