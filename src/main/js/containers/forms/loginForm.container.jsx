import React from 'react';
import LoginForm from '../../components/forms/loginForm.component';
import { loginUser } from '../../api/user.repository';

class LoginFormContainer extends React.Component {

    onLoginUser(user) {
        return loginUser(user);
    }

    render() {
        return (
            <LoginForm onLoginHandler={this.onLoginUser}/>
        );
    }

}
export default LoginFormContainer;
