import React from 'react';
import PropTypes from 'prop-types';
import {Button, ButtonGroup, ControlLabel, FormControl, FormGroup, HelpBlock} from "react-bootstrap";

class BooksForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            book: {
                title: '',
                description: '',
                releaseYear: '',
                category: {
                    id: -1,
                },
                author: {
                    id: -1,
                },
            }
            ,
        };
    }

    shouldComponentUpdate(nextProps, nextState) {
        if (this.props.categories.length !== nextProps.categories.length || this.props.authors.length !== nextProps.authors.length) {
            return true;
        }

        return false;
    }

    componentDidUpdate() {
        const { categories } = this.props;
        const { authors } = this.props;

        if (categories.length > 0)  {
            this.setState(state => ({
                ...state,
                book: {
                    ...state.book,
                    category: {
                        id: categories[0].id,
                    },
                },
            }));
        }


        if (authors.length > 0)  {
            this.setState(state => ({
                ...state,
                book: {
                    ...state.book,
                    author: {
                        id: authors[0].id,
                    },
                },
            }));
        }
    }

    onChangeReleaseYear(e) {
        const releaseYear = e.target.value;
        this.setState(state => ({
            ...state,
            book: {
                ...state.book,
                releaseYear,
            }
        }));
    }


    onChangeTitle(e) {
        const title = e.target.value;
        this.setState(state => ({
            ...state,
            book: {
                ...state.book,
                title,
            }
        }));
    }

    onChangeDescription(e) {
        const description = e.target.value;
        this.setState(state => ({
            ...state,
            book: {
                ...state.book,
                description,
            }
        }));
    }

    onChangeAuthor(e) {
        const id = e.target.value;
        this.setState(state => ({
            ...state,
            book: {
                ...state.book,
                author: {
                    id,
                },
            }
        }));
    }

    onChangeCategory(e) {
        const id = e.target.value;
        this.setState(state => ({
            ...state,
            book: {
                ...state.book,
                category: {
                    id,
                },
            }
        }));
    }

    clearForm() {
        this.setState(state => ({
            ...state,
            book: {
                title: '',
                description: '',
                releaseYear: 2018,
            },
        }));
        this.inputTitle.value = '';
        this.inputDescription.value = '';
        this.inputReleaseYear.value = '';
    }

    handleAddButton() {
        this.props.handleCreateBook(this.state.book)
            .then(() => this.clearForm())
            .catch(() => console.warn('Something goes wrong'));
    }

    mapAuthorsToSelect(authors) {
        return authors.map(author => {
            const label = `${author.authorName} ${author.authorLastName}`;
            return (
                <option key={author.id} value={author.id}>{label}</option>
            );
        });
    }

    mapCategoriesToSelect(categories) {
        return categories.map(category => {
            return (
                <option key={category.id} value={category.id}>{category.categoryName}</option>
            );
        });
    }

    render () {
        return (
            <form onClick={e => e.preventDefault()}>
                <h2 className="title">Add book</h2>
                <FormGroup
                    controlId="title"
                >
                    <ControlLabel>Title</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={(input) => this.onChangeTitle(input)}
                        inputRef={ref => { this.inputTitle = ref; }}
                        placeholder="Enter book title"
                    />
                    <FormControl.Feedback />
                    <HelpBlock>Title cannot be empty.</HelpBlock>
                </FormGroup>
                <FormGroup
                    controlId="description"
                >
                    <ControlLabel>Description</ControlLabel>
                    <FormControl
                        type="text"
                        onChange={input => this.onChangeDescription(input)}
                        inputRef={ref => { this.inputDescription = ref; }}
                        placeholder="Enter book description"
                    />
                    <FormControl.Feedback />
                </FormGroup>
                <FormGroup
                    controlId="releaseYear"
                >
                    <ControlLabel>Release Year</ControlLabel>
                    <FormControl
                        type="number"
                        onChange={input => this.onChangeReleaseYear(input)}
                        inputRef={ref => { this.inputReleaseYear = ref; }}
                        placeholder="Enter book release year"
                    />
                    <HelpBlock>Release year cannot be empty.</HelpBlock>
                    <FormControl.Feedback />
                </FormGroup>
                <FormGroup
                    controlId="authors"
                >
                    <ControlLabel>Author</ControlLabel>
                    <FormControl
                        componentClass="select"
                        placeholder="Choose an author"
                        onChange={input => this.onChangeAuthor(input)}
                    >
                        {this.mapAuthorsToSelect(this.props.authors)}
                    </FormControl>
                    <FormControl.Feedback />
                </FormGroup>
                <FormGroup
                    controlId="categories"
                >
                    <ControlLabel>Category</ControlLabel>
                    <FormControl
                        componentClass="select"
                        placeholder="Choose a category"
                        onChange={input => this.onChangeCategory(input)}
                    >
                        {this.mapCategoriesToSelect(this.props.categories)}
                    </FormControl>
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
BooksForm.propTypes = {
    handleCreateBook: PropTypes.func.isRequired,
    categories: PropTypes.arrayOf(Object).isRequired,
    authors: PropTypes.arrayOf(Object).isRequired,
};
export default BooksForm;