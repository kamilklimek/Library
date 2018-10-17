import React, { Component } from 'react';
import NavbarHeader from '../components/navbar.component'
import {Route, Switch} from "react-router-dom";
import IndexContainer from "./index.container";
import BooksContainer from "./books.container";

class AppContainer extends Component {
  render() {
    return (
      <div className="App">
          <NavbarHeader />
          <Switch>
              <Route exact path='/' component={IndexContainer}/>
              <Route path='/books' component={BooksContainer}/>
          </Switch>
      </div>
    );
  }
}

export default AppContainer;
