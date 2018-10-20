import React from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import '../../../css/reactTable.css';
import {TiEdit, TiDelete} from "react-icons/ti";

class AuthorsTable extends React.Component {

    constructor(props) {
        super(props);

        this.columns = [
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Category',
                accessor: 'categoryName',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Description',
                accessor: 'description',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Edit',
                accessor: 'id',
                Cell: props => <button className="edit-button" onClick={() => this.props.onEditCategory(props.value)}><TiEdit size={32} /></button>
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Remove',
                accessor: 'id',
                Cell: props => <button className="delete-button" onClick={() => this.props.onRemoveCategory(props.value)}><TiDelete size={32} /></button>
            }
        ];
    }

    render() {
        return (
            <ReactTable columns={this.columns} data={this.props.categories}  />
        );
    }
}
AuthorsTable.propTypes = {
    categories: PropTypes.arrayOf(PropTypes.shape({
        id: PropTypes.number.isRequired,
        categoryName: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
    })).isRequired,
    onRemoveCategory: PropTypes.func.isRequired,
    onEditCategory: PropTypes.func.isRequired,
};
export default AuthorsTable;