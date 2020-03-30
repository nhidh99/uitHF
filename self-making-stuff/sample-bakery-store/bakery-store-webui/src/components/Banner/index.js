import React, { Component } from "react";
import { UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem, Button } from 'reactstrap';
import styles from './styles.module.scss';
import { Link, withRouter } from "react-router-dom";

class Banner extends Component {


    componentDidMount() {
    }

    login = () => {
        window.location.href = "/login";
    }

    logout = async () => {
        const url = "/api/users/logout";
        await fetch(url, {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });
        localStorage.removeItem('token');
        window.location.href = "/login";
    }

    viewOrders = () => {
        this.props.history.push("/order");
    }

    render() {
        return (
            <div className={styles.banner}>
                <Link to="/" className={styles.name}>
                    <title id="banner-title"><span role="img" aria-label="cake">🎂</span> BAKERY STORE</title>
                </Link>
                {
                    localStorage.getItem('token') !== null ? 
                    <UncontrolledDropdown className={styles.dropDown}>
                        <DropdownToggle><span>⚙</span></DropdownToggle>
                        <DropdownMenu right>
                            <DropdownItem onClick={this.viewOrders}>My Orders</DropdownItem>
                            <DropdownItem onClick={this.logout}>Log out</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown> : <Button onClick={this.login}>Login</Button>
                }
            </div>
        );
    }
}

export default withRouter(Banner);