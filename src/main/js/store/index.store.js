import { createStore } from 'redux';
import indexReducer from './index.reducer';

const initialState = {
    authors: [],
    books: [],
    categories: [],
};

const store = createStore(indexReducer, initialState);
export default store;