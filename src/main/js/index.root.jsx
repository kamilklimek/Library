import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {BrowserRouter} from 'react-router-dom'
import * as serviceWorker from './serviceWorker';
import AppContainer from "./containers/app.container";
import store from './store/index.store';
import '../css/index.css';

ReactDOM.render((
    <Provider store={store}>
        <BrowserRouter>
                <AppContainer/>
        </BrowserRouter>
    </Provider>
), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
