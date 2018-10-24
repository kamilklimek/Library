import React from 'react';
import {Button, ButtonGroup, ControlLabel, FormControl, FormGroup, HelpBlock} from "react-bootstrap";
import PropTypes from 'prop-types';

class RegisterForm extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            user: {
                login: '',
                password: '',
            }
        }
    }

    onChangeLogin(e) {
        const login = e.target.value;
        this.setState(state => ({
            ...state,
            user: {
                ...state.user,
                login,
            }
        }));
    }

    onChangePassword(e) {
        const password = e.target.value;
        this.setState(state => ({
            ...state,
            user: {
                ...state.user,
                password,
            }
        }));
    }

    clearForm() {
        this.setState(state => ({
            ...state,
            user: {
                login: '',
                password: '',
            }
        }));
    }

    handleRegisterButton() {
        this.props.onLoginHandler(this.state.user)
            .then(this.clearForm);
    }

    render() {
        const { user } = this.state;
        return (
            <form onClick={e => e.preventDefault()}>
                <h2 className="title">Sign in</h2>

                <FormGroup
                    controlId="loginForm-login"
                >
                    <ControlLabel>Login</ControlLabel>
                    <FormControl
                        type="text"
                        value={user.login}
                        placeholder="Enter login"
                        onChange={(input) => this.onChangeLogin(input)}
                    />
                </FormGroup>

                <FormGroup
                    controlId="loginForm-password"
                >
                    <ControlLabel>Password</ControlLabel>
                    <FormControl
                        type="password"
                        value={user.password}
                        placeholder="Enter password"
                        onChange={(input) => this.onChangePassword(input)}
                    />
                </FormGroup>
                <ButtonGroup>
                    <Button bsStyle="primary" type="submit" onClick={() => this.handleRegisterButton()}>Sign in</Button>
                </ButtonGroup>
            </form>
        );
    }
}
RegisterForm.propTypes = {
    onLoginHandler: PropTypes.func.isRequired,
};
export default RegisterForm;