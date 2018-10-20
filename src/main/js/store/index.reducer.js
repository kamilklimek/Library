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
    }

    return state;
}