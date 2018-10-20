import React, {Component} from 'react';
import NavbarHeader from '../components/navbar.component'
import {Route, Switch} from "react-router-dom";
import IndexContainer from "./index.container";
import BooksContainer from "./books.container";
import AuthorsContainer from "./authors.container";
import CategoriesContainer from "./categories.container";
import {getAuthors} from "../api/author.repository";
import {setAuthors, setBooks, setCategories} from "../store/index.manager";
import {prepareFetchAuthors} from "../utils/author.utils";
import {getBooks} from "../api/books.repository";
import {getCategories} from "../api/category.repository";

class AppContainer extends Component {

    componentDidMount() {
        getAuthors().then(data => setAuthors(prepareFetchAuthors(data)));
        getBooks().then(data => setBooks(data));
        getCategories().then(data => setCategories(data));
    }

    render() {
        return (
            <div className="App">
                <NavbarHeader/>
                <Switch>
                    <Route exact path='/' component={IndexContainer}/>
                    <Route path='/books' component={BooksContainer}/>
                    <Route path='/authors' component={AuthorsContainer}/>
                    <Route path='/categories' component={CategoriesContainer}/>
                </Switch>
            </div>
        );
    }
}

export default AppContainer;
