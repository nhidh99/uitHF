import React, { Component } from "react";
import { Form, FormGroup, Input, Button, Label } from "reactstrap";
import styles from './styles.module.scss';
import { handleError } from "../../service/api/handleError";

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = { error: null }
    }

    handleKeyPress = (e) => {
        if (e.which === 13) {
            this.login();
        }
    }

    login = () => {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const url = "/api/users/login";

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({
                username: username,
                password: password
            })
        }).then(response => {
            if (!response.ok) {
                throw Error(response.status);
            }
            return response.text();
        }).then(token => {
            localStorage.setItem('token', token);
            window.location.href = "/";
        }).catch(err => {
            const status = parseInt(err.message);
            switch (status) {
                case 401:
                    this.setState({ error: "Invalid username or password" })
                    break;
                default:
                    this.setState({ error: "Server error" });
                    break;
            }
        });
    }

    render() {
        return (
            <Form className={styles.form}>
                <FormGroup>
                    <Label>Bakery Store</Label>
                    <Input id='username' type="text" placeholder="Username" />
                    <Input id='password' type="password" placeholder="Password" onKeyPress={this.handleKeyPress} />
                    <Button onClick={this.login}>Login</Button>
                    <p className={styles.error}>{this.state.error}</p>
                </FormGroup>
            </Form>
        )
    }
}

export default Login;