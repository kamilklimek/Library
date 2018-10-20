import React from 'react';
import { Navbar, NavItem, NavDropdown, MenuItem, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class NavbarHeader extends React.Component {
    render() {
        return (
            <Navbar>
                <Navbar.Header>
                    <Navbar.Brand>
                        <Link to="/">Library</Link>
                    </Navbar.Brand>
                </Navbar.Header>
                <Nav>
                    <NavItem eventKey={1} href="/books">
                        Books
                    </NavItem>
                    <NavItem eventKey={2} href="/authors">
                        Authors
                    </NavItem>
                    <NavItem eventKey={2} href="/categories">
                        Categories
                    </NavItem>
                </Nav>
            </Navbar>
        );
    }
}

export default NavbarHeader;