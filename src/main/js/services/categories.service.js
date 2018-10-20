import {getCategoriesFromStore} from "../store/index.manager";

export default function getCategoryById(id) {
    return getCategoriesFromStore().find(category => category.id === id);
}