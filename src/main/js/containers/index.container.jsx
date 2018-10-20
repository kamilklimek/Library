import React, {Component} from 'react';
import RegisterFromContainer from "./forms/registerForm.container";

class IndexContainer extends Component {
    render() {
        return (
            <div className="mainContainer">
                <h2>Sign in</h2>
                <RegisterFromContainer/>
            </div>
        );
    }
}

export default IndexContainer;
