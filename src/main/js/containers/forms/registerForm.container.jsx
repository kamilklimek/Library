import React from 'react';
import RegisterForm from "../../components/forms/registerForm.component";

class RegisterFromContainer extends React.Component {

    onRegisterUser(user) {
        console.log(user)
    }

    render() {
        return (
            <RegisterForm onRegisterHandler={this.onRegisterUser}/>
        );
    }

}
export default RegisterFromContainer;
