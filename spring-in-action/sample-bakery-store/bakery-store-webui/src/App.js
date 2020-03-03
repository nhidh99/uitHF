import React, { Component } from 'react';
import './App.scss';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import Home from './scenes/Home';
import Login from './scenes/Login';
import Order from './scenes/Order';
import Banner from './components/Banner';
import Exception from './scenes/Exception';

class App extends Component {
	render() {
		return (
			<div>
				<BrowserRouter>
					<Banner />
					<Switch>
						<Route exact component={Home} path="/" />
						<Route exact component={Exception} path="/exception" />
						<Route exact path="/order" render={() =>
							localStorage.getItem('token')
								? <Order />
								: <Redirect to="/login" />
						} />
						<Route exact path="/login" render={() =>
							localStorage.getItem('token')
								? <Redirect to="/" />
								: <Login />
						} />
					</Switch>
				</BrowserRouter>
			</div>
		);
	}
}

export default App;
