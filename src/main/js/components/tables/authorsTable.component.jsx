import React from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import '../../../css/reactTable.css';
import {TiDeleteOutline, TiEdit} from "react-icons/ti";

class AuthorsTable extends React.Component {

    constructor(props) {
        super(props);

        this.columns = [
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Name',
                accessor: 'authorName',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Last name',
                accessor: 'authorLastName',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Born date',
                accessor: 'bornDate',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Edit',
                accessor: 'id',
                Cell: props => <button className="edit-button" onClick={() => this.props.onEditAuthor(props.value)}><TiEdit size={32} /></button>
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Remove',
                accessor: 'id',
                Cell: props => <button className="delete-button" onClick={() => this.props.onRemoveAuthor(props.value)}><TiDeleteOutline size={32} /></button>
            }
        ];
    }

    render() {
        return (
            <ReactTable columns={this.columns} data={this.props.authors}  />
        );
    }
}
AuthorsTable.propTypes = {
    authors: PropTypes.arrayOf(PropTypes.shape({
        id: PropTypes.number.isRequired,
        authorName: PropTypes.string.isRequired,
        authorLastName: PropTypes.string.isRequired,
        bornDate: PropTypes.string.isRequired,
    })).isRequired,
    onRemoveAuthor: PropTypes.func.isRequired,
    onEditAuthor: PropTypes.func.isRequired,
}
export default AuthorsTable;