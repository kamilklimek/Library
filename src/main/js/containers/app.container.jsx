import React, { Component } from 'react';
import NavbarHeader from '../components/navbar.component'
import {Route, Switch} from "react-router-dom";
import IndexContainer from "./index.container";
import BooksContainer from "./books.container";
import AuthorsContainer from "./authors.container";
import {getAuthors} from "../api/author.repository";

class AppContainer extends Component {

    componentDidMount() {
        getAuthors().then(authors => console.log(authors))
    }

    render() {
        return (
            <div className="App">
                <NavbarHeader/>
                <Switch>
                    <Route exact path='/' component={IndexContainer}/>
                    <Route path='/books' component={BooksContainer}/>
                    <Route path='/authors' component={AuthorsContainer}/>
                </Switch>
            </div>
        );
    }
}

export default AppContainer;
