import React, { Component } from "react";
import { CardImg, Card, CardBody, CardTitle, CardSubtitle, Container, Row, Col } from "reactstrap";
import styles from './styles.module.scss';
import { handleError } from "../../service/api/handleError";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            loading: true,
            products: []
        }
    }

    async componentDidMount() {
        const products = await this.fetchProducts();
        this.setState({
            loading: false,
            products: products
        });
    }

    fetchProducts = () => {
        const url = "/api/products";
        return fetch(url, { method: 'GET' })
            .then(response => {
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
                : <Container className={styles.container}>
                    <Row className={styles.row}>
                        {
                            this.state.products.map(product =>
                                <Col className={styles.col}>
                                    <Card className={styles.card}>
                                        <CardImg className={styles.cardImg} src={require(`../../images/${product['image_link']}`)} alt={product['name']} />
                                        <CardBody className={styles.cardBody}>
                                            <CardTitle className={styles.name}>{product['name']}</CardTitle>
                                            <CardSubtitle className={styles.price}>
                                                {Number(product['price']).toLocaleString('vn')}<sup>đ</sup>
                                            </CardSubtitle>
                                        </CardBody>
                                    </Card>
                                </Col>)
                        }
                    </Row>
                </Container>
        );
    }
}

export default Home;