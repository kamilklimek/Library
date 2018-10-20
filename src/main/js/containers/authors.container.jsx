import React from 'react';
import AuthorsTable from "../components/AuthorsTable";
import {connect} from 'react-redux';
import {getAuthors} from "../api/author.repository";
import AuthorsFormContainer from "./authorsForm.container.jsx";
import {prepareFetchAuthors} from "../utils/author.utils";
import {setAuthors} from "../store/index.manager";

class AuthorsContainer extends React.Component {


    componentDidMount() {
        getAuthors().then(authors => setAuthors(prepareFetchAuthors(authors)));
    }

    render() {
        return (
            <div className="authors__container">
                <AuthorsTable authors={this.props.authors} />
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
