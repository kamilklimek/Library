import moment from 'moment';
import { createStore } from 'redux';
import indexReducer from './index.reducer';

const initialState = {
    authors: [
        {
            id: 1,
            authorName: 'Henryk',
            authorLastName: 'Sienkiewicz',
            bornDate: '2018-05-04',
        },
        {
            id: 2,
            authorName: 'Henryk2',
            authorLastName: 'Sienkiewicz2',
            bornDate: '2018-05-06',
        },
    ],
    books: [
        {
            id: 1,
            title: 'Henryk',
            description: 'Sienkiewicz',
            releaseYear: 1884,
            author: {
                id: 1,
                authorLastName: 'Sienkiewicz',
            },
            category: {
                id: 1,
                categoryName: 'Przygodowe',
            }
        },
    ],
    categories: [
        {
            id: 1,
            categoryName: 'Przygodowe',
            description: 'Sienkiewicz2',
        },
    ],
};

const store = createStore(indexReducer, initialState);
export default store;