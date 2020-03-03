import React, { Component } from "react";
import { Label } from "reactstrap";
import styles from './styles.module.scss'

class Exception extends Component {

    render() {
        return (
            <Label className={styles.title}>
                Oops, something's gone wrong!<br/>
                Try again later while we're making more cakes for your day!
            </Label>
        );
    }
}

export default Exception;