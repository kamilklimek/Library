import React from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import '../../../css/reactTable.css';

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
}
export default BooksTable;