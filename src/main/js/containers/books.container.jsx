import React, {Component} from 'react';
import connect from "react-redux/es/connect/connect";
import BooksFormContainer from "./forms/booksForm.container";
import BooksTable from "../components/tables/booksTable.component";
import RemoveBookDialogContainer from "./dialogs/removeBook.dialog.container";

class BooksContainer extends Component {

    onRemoveBook(id) {
        RemoveBookDialogContainer.openDialog(id);
    }

    render() {
        return (
            <div className="authors__container">
                <BooksTable books={this.props.books} onRemoveBook={this.onRemoveBook} />
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
