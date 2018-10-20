import React from 'react';
import AuthorsTableComponent from "../components/tables/authorsTable.component";
import {connect} from 'react-redux';
import AuthorsFormContainer from "./forms/authorsForm.container.jsx";
import RemoveAuthorDialogContainer from "./dialogs/remove/removeAuthor.dialog.container";
import EditAuthorDialogContainer from "./dialogs/edit/editAuthor.dialog.container";

class AuthorsContainer extends React.Component {

    onRemoveAuthor(id) {
        RemoveAuthorDialogContainer.openDialog(id);
    }

    onEditAuthor(id) {
        EditAuthorDialogContainer.openDialog(id);
    }


    render() {
        return (
            <div className="authors__container">
                <AuthorsTableComponent authors={this.props.authors} onRemoveAuthor={this.onRemoveAuthor} onEditAuthor={this.onEditAuthor} />
                <AuthorsFormContainer />
            </div>
        );
    }
}

const mapStateToProps = function(store) {
    return {
        authors: store.authors,
    };
};

export default connect(mapStateToProps)(AuthorsContainer);
