import React, { Component, Fragment } from "react";
import styles from './styles.module.scss';
import { Table, Label } from "reactstrap";
import { handleError } from "../../service/api/handleError";

class Order extends Component {

    constructor(props) {
        super(props);
        this.state = {
            loading: true,
            orders: []
        }
    }

    async componentDidMount() {
        const orders = await this.fetchOrders();
        this.setState({
            loading: false,
            orders: orders
        });
    }

    fetchOrders = () => {
        const url = "/api/orders";
        return fetch(url, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        }).then(response => {
            if (!response.ok) {
                throw Error(response.status);
            }
            return response.json();
        }).catch(err => {
            const status = parseInt(err.message);
            handleError(status);
        });
    }

    render() {
        return (
            this.state.loading
                ? null
                : <div className={styles.order}>
                    {
                        this.state.orders.length === 0
                            ? <Label className={styles.title}>You don't have any orders...<br/>Go get some cakes for your day!</Label>
                            : <Fragment>
                                <Label className={styles.title}>My Orders</Label>
                                <Table className={styles.table} borderless striped>
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Item</th>
                                            <th>Quantity</th>
                                            <th>Unit Price</th>
                                            <th>Total Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {
                                            this.state.orders.map(order => (
                                                <tr>
                                                    <td></td>
                                                    <td>{order['product']['name']}</td>
                                                    <td>{order['quantity']}</td>
                                                    <td>{Number(order['unit_price']).toLocaleString('vn')}<sup>đ</sup></td>
                                                    <td>{Number(order['quantity'] * order['unit_price']).toLocaleString('vn')}<sup>đ</sup></td>
                                                </tr>
                                            ))
                                        }
                                    </tbody>
                                </Table>
                                <Label className={styles.total}>
                                    Total: {
                                        Number(this.state.orders
                                            .map(order => order['quantity'] * order['unit_price'])
                                            .reduce((a, b) => a + b)).toLocaleString('vn')
                                    }<sup>đ</sup>
                                </Label>
                            </Fragment>
                    }
                </div>
        );
    }
}

export default Order;