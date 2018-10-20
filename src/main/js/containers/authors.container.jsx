import React from 'react';
import AuthorsTableComponent from "../components/tables/authorsTable.component";
import {connect} from 'react-redux';
import AuthorsFormContainer from "./forms/authorsForm.container.jsx";

class AuthorsContainer extends React.Component {

    render() {
        return (
            <div className="authors__container">
                <AuthorsTableComponent authors={this.props.authors} />
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
