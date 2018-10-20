import React from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import '../../../css/reactTable.css';

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
}
export default AuthorsTable;