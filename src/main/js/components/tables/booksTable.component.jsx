import React from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import '../../../css/reactTable.css';
import {TiDeleteOutline, TiEdit, TiFolderAdd} from "react-icons/ti";

class BooksTable extends React.Component {

    constructor(props) {
        super(props);

        this.columns = [
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Title',
                accessor: 'title',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Description',
                accessor: 'description',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Release year',
                accessor: 'releaseYear',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Author',
                accessor: 'author.authorLastName',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Category',
                accessor: 'category.categoryName',
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Edit',
                accessor: 'id',
                Cell: props => <button className="edit-button" onClick={() => this.props.onEditBook(props.value)}><TiEdit size={32} /></button>
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Remove',
                accessor: 'category.id',
                Cell: props => <button className="delete-button" onClick={() => this.props.onRemoveBook(props.value)}><TiDeleteOutline size={32} /></button>
            },
            {
                headerClassName: 'my-favorites-column-header-group',
                Header: 'Borrow book',
                accessor: 'id',
                Cell: props => <button className="borrow-button" onClick={() => this.props.onBorrowBook(props.value)}><TiFolderAdd size={32} /></button>
            }
        ];
    }

    render() {
        return (
            <ReactTable columns={this.columns} data={this.props.books}  />
        );
    }
}
BooksTable.propTypes = {
    books: PropTypes.arrayOf(PropTypes.shape({
        id: PropTypes.number.isRequired,
        title: PropTypes.string.isRequired,
        description: PropTypes.string.isRequired,
        releaseYear: PropTypes.number.isRequired,
        author: PropTypes.instanceOf(Object).isRequired,
        category: PropTypes.instanceOf(Object).isRequired,
    })).isRequired,
    onRemoveBook: PropTypes.func.isRequired,
    onEditBook: PropTypes.func.isRequired,
    onBorrowBook: PropTypes.func.isRequired,
}
export default BooksTable;