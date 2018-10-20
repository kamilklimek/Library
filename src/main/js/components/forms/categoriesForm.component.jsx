import React from 'react';
import PropTypes from 'prop-types';
import {Button, ButtonGroup, ControlLabel, FormControl, FormGroup, HelpBlock} from "react-bootstrap";

class CategoriesForm extends React.Component {


    constructor(props) {
        super(props);

        this.state = {
            category: {
                categoryName: '',
                description: '',
            },
        };
    }

    onChangeCategoryName(e) {
        const categoryName = e.target.value;
        this.setState(state => ({
            ...state,
            category: {
                ...state.category,
                categoryName,
            },
        }));
    }

    onChangeDescription(e) {
        const description = e.target.value;
        this.setState(state => ({
            ...state,
            category: {
                ...state.category,
                description,
            },
        }));
    }


    validateCategoryName() {
        if (this.state.category.categoryName.length === 0) {
            return 'warning';
        }

        return 'success';
    }


    clearForm() {
        this.setState(state => ({
            ...state,
            category: {
                categoryName: '',
                description: '',
            },
        }));
        this.inputCategoryName.value = '';
        this.inputDescription.value = '';
    }

    handleAddButton() {
        this.props.handleCreateCategory(this.state.category)
            .then(() => this.clearForm())
            .catch(() => console.warn('Something goes wrong'));
    }


    render () {
        return (
            <form onClick={e => e.preventDefault()}>
                <h2 className="title">Add category</h2>
                <FormGroup
                    controlId="categoryName"
                    validationState={this.validateCategoryName()}
                >
                    <ControlLabel>Name</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={(input) => this.onChangeCategoryName(input)}
                        inputRef={ref => { this.inputCategoryName = ref; }}
                        placeholder="Enter category name"
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Category name cannot be empty.</HelpBlock>
                </FormGroup>
                <FormGroup
                    controlId="authorLastName"
                >
                    <ControlLabel>Description</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={input => this.onChangeDescription(input)}
                        inputRef={ref => { this.inputDescription = ref; }}
                        placeholder="Enter category description"
                    />
                    <FormControl.Feedback />
                </FormGroup>

                <ButtonGroup>
                    <Button type="reset" onClick={() => this.clearForm()}>Clear</Button>
                    <Button type="submit" onClick={() => this.handleAddButton()}>Add</Button>
                </ButtonGroup>
            </form>
        )
    }
}
CategoriesForm.propTypes = {
    handleCreateCategory: PropTypes.func.isRequired,
};
export default CategoriesForm;