import React from 'react';
import RegisterForm from "../../components/forms/registerForm.component";
import { registerUser } from '../../api/user.repository';

class RegisterFromContainer extends React.Component {

    onRegisterUser(user) {
        return registerUser(user);
    }

    render() {
        return (
            <RegisterForm onRegisterHandler={this.onRegisterUser}/>
        );
    }

}
export default RegisterFromContainer;
