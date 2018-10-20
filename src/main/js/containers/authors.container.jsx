import React from 'react';
import AuthorsTableComponent from "../components/tables/authorsTable.component";
import {connect} from 'react-redux';
import AuthorsFormContainer from "./forms/authorsForm.container.jsx";
import RemoveAuthorDialogContainer from "./dialogs/removeAuthor.dialog.container";

class AuthorsContainer extends React.Component {

    onRemoveAuthor(id) {
        RemoveAuthorDialogContainer.openDialog(id);
    }

    render() {
        return (
            <div className="authors__container">
                <AuthorsTableComponent authors={this.props.authors} onRemoveAuthor={this.onRemoveAuthor}/>
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
