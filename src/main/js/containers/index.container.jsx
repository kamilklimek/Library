import React, {Component} from 'react';
import RegisterFromContainer from "./forms/registerForm.container";
import LoginFormContainer from "./forms/loginForm.container";

class IndexContainer extends Component {
    render() {
        return (
            <div className="mainContainer">
                <LoginFormContainer/>
                <RegisterFromContainer/>
            </div>
        );
    }
}

export default IndexContainer;
