import React, {Component} from 'react';
import connect from "react-redux/es/connect/connect";
import BooksFormContainer from "./forms/booksForm.container";
import BooksTable from "../components/tables/booksTable.component";
import RemoveBookDialogContainer from "./dialogs/remove/removeBook.dialog.container";
import EditBookDialogContainer from "./dialogs/edit/editBookdialog.container";

class BooksContainer extends Component {

    onRemoveBook(id) {
        RemoveBookDialogContainer.openDialog(id);
    }

    editBook(id) {
        EditBookDialogContainer.openDialog(id);
    }

    render() {
        return (
            <div className="authors__container">
                <BooksTable books={this.props.books} onRemoveBook={this.onRemoveBook} onEditBook={this.editBook} />
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
