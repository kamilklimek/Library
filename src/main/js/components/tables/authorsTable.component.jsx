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
}
export default AuthorsTable;