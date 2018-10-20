export default function indexReducer(state = {}, action) {
    switch(action.type) {
        case 'SET_AUTHORS': {
            return {
                ...state,
                authors: action.authors,
            };
        }
        case 'ADD_AUTHOR': {
            return {
                ...state,
                authors: [
                    ...state.authors,
                    action.author,
                ],
            };
        }
        case 'SET_BOOKS': {
            return {
                ...state,
                books: action.books,
            };
        }
        case 'ADD_BOOK': {
            return {
                ...state,
                books: [
                    ...state.books,
                    action.book,
                ],
            };
        }
        case 'SET_CATEGORIES': {
            return {
                ...state,
                categories: action.categories,
            };
        }
        case 'ADD_CATEGORY': {
            return {
                ...state,
                categories: [
                    ...state.categories,
                    action.category,
                ],
            };
        }
        case 'REMOVE_BOOK': {
            return {
                ...state,
                books: state.books.filter(book => book.id !== action.id),
            };
        }
        case 'REMOVE_CATEGORY': {
            return {
                ...state,
                categories: state.categories.filter(category => category.id !== action.id),
            };
        }
        case 'REMOVE_AUTHOR': {
            return {
                ...state,
                authors: state.authors.filter(author => author.id !== action.id),
            };
        }
    }

    return state;
}