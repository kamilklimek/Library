import React from 'react';
import PropTypes from 'prop-types';
import {Button, ButtonGroup, ControlLabel, FormControl, FormGroup, HelpBlock} from "react-bootstrap";
import Calendar from "react-calendar";
import EditAuthorDialogContainer from "../../containers/dialogs/edit/editAuthor.dialog.container";

class AuthorsForm extends React.Component {


    constructor(props) {
        super(props);

        this.state = {
            author: this.props.author,
        };
    }

    componentDidMount() {
        this.inputName.value = this.props.author.authorName;
        this.inputLastName.value = this.props.author.authorLastName;
    }

    onChangeDate(bornDate) {
        this.setState(state => ({
            ...state,
            author: {
                ...state.author,
                bornDate,
            },
        }));
    }


    validateAuthorName() {
        if (this.state.author.authorName.length === 0) {
            return 'warning';
        }

        return 'success';
    }

    validateAuthorLastName() {
        if (this.state.author.authorLastName.length === 0) {
            return 'warning';
        }

        return 'success';
    }

    onInputNameChange(e) {
        const name = e.target.value;
        this.setState(state => ({
            ...state,
            author: {
                ...state.author,
                authorName: name,
            },
        }));
    }

    onInputLastNameChange(e) {
        const lastName = e.target.value;
        this.setState(state => ({
            ...state,
            author: {
                ...state.author,
                authorLastName: lastName,
            },
        }));
    }

    clearForm() {
        this.setState(state => ({
            ...state,
            author: {
                authorName: '',
                authorLastName: '',
                bornDate: new Date(),
            },
        }));
        this.inputLastName.value = '';
        this.inputName.value = '';
    }

    handleActionButton() {
        this.props.handleActionAuthor(this.state.author)
            .then(() => this.clearForm())
            .catch(() => console.warn('Something goes wrong'));
    }


    render () {
        return (
            <form onClick={e => e.preventDefault()}>
                <h2 className="title">{this.props.title}</h2>
                <FormGroup
                    controlId="authorName"
                    validationState={this.validateAuthorName()}
                >
                    <ControlLabel>Name</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={(input) => this.onInputNameChange(input)}
                        inputRef={ref => { this.inputName = ref; }}
                        placeholder="Enter author name"
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Name cannot be empty.</HelpBlock>
                </FormGroup>
                <FormGroup
                    controlId="authorLastName"
                    validationState={this.validateAuthorLastName()}
                >
                    <ControlLabel>Last name</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={input => this.onInputLastNameChange(input)}
                        inputRef={ref => { this.inputLastName = ref; }}
                        placeholder="Enter author last name"
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Last name cannot be empty.</HelpBlock>
                </FormGroup>
                <FormGroup
                    controlId="authorBornDate"
                >
                    <ControlLabel>Born date</ControlLabel>
                    <Calendar
                        onChange={(input) => this.onChangeDate(input)}
                        value={this.state.author.bornDate}
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Date should be before today.</HelpBlock>
                </FormGroup>

                <ButtonGroup>
                    { this.props.isEditMode && <Button bsStyle="warning" type="submit" onClick={EditAuthorDialogContainer.closeDialog}>Close</Button>}
                    <Button type="reset" onClick={() => this.clearForm()}>Clear</Button>
                    <Button bsStyle="primary" type="submit" onClick={() => this.handleActionButton()}>{this.props.isEditMode ? 'Edit' : 'Add'}</Button>
                </ButtonGroup>
            </form>
        )
    }
}
AuthorsForm.defaultProps = {
    author: {
        authorLastName: '',
        authorName: '',
        bornDate: new Date(),
    },
    isEditMode: false,
};

AuthorsForm.propTypes = {
    handleActionAuthor: PropTypes.func.isRequired,
    title: PropTypes.string.isRequired,
    author: PropTypes.object,
    isEditMode: PropTypes.bool,
};
export default AuthorsForm;