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
                email: '',
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

    onChangeEmail(e) {
        const email = e.target.value;
        this.setState(state => ({
            ...state,
            user: {
                ...state.user,
                email,
            }
        }));
    }

    clearForm() {
        this.setState(state => ({
            ...state,
            user: {
                login: '',
                password: '',
                email: '',
            }
        }));
    }

    handleRegisterButton() {
        this.props.onRegisterHandler(this.state.user)
            .then(this.clearForm);
    }

    render() {
        const { user } = this.state;
        return (
            <form onClick={e => e.preventDefault()}>
                <h2 className="title">Sign up</h2>

                <FormGroup
                    controlId="login"
                >
                    <ControlLabel>Login</ControlLabel>
                    <FormControl
                        type="text"
                        value={user.login}
                        placeholder="Enter login"
                        onChange={(input) => this.onChangeLogin(input)}
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Login must be longer than 5</HelpBlock>
                </FormGroup>
                <FormGroup
                    controlId="email"
                >
                    <ControlLabel>E-mail</ControlLabel>
                    <FormControl
                        type="email"
                        value={user.email}
                        placeholder="Enter e-mail"
                        onChange={(input) => this.onChangeEmail(input)}
                    />
                    <FormControl.Feedback />
                </FormGroup>
                <FormGroup
                    controlId="password"
                >
                    <ControlLabel>Password</ControlLabel>
                    <FormControl
                        type="password"
                        value={user.password}
                        placeholder="Enter password"
                        onChange={(input) => this.onChangePassword(input)}
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Password must be min 8 characters</HelpBlock>
                </FormGroup>
                <ButtonGroup>
                    <Button type="reset" onClick={() => this.clearForm()}>Clear</Button>
                    <Button bsStyle="primary" type="submit" onClick={() => this.handleRegisterButton()}>Sign up</Button>
                </ButtonGroup>
            </form>
        );
    }
}
RegisterForm.propTypes = {
    onRegisterHandler: PropTypes.func.isRequired,
};
export default RegisterForm;