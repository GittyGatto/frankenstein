import '../../styles/index.scss';
import React from 'react';
import RestrictAccess from './restrict-access';
import {HashRouter, Route, Switch} from 'react-router-dom';
import {HomePage} from './home-page';

export default class App extends React.Component {
	render() {
		return (<RestrictAccess>
			<HashRouter>
					<Switch>
						<Route path="/" component={HomePage}/>
					</Switch>
			</HashRouter>
		</RestrictAccess>);
	}
}
