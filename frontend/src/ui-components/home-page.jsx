import '../../styles/index.scss';
import React from 'react';
import {dispatcher} from '../util/mini-flux';
import logout from "../actions/logout-action";
import bgImage from "../assets/images/cc0-desktop-backgrounds-fog-7919.jpg";
import './Home-Page.css';
import {Button, FormControl} from "react-bootstrap";

export class HomePage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            isAuthenticated: props.isAuthenticated,
            getUser: props.getUser,
        };

        this._onChange = this._onChange.bind(this);
    }

    componentDidMount() {
        dispatcher.subscribe(this._onChange);
    }

    componentWillUnmount() {
        dispatcher.unsubscribe(this._onChange);
    }

    _onChange(ev) {
        const {isAuthenticated, getUser} = ev;
        const newState = {
            isAuthenticated,
            getUser,
        };
        this.setState(newState);
    }

    render() {
        const {getUser, isAuthenticated} = this.state;
        const formStyle = {backgroundImage: 'url("' + bgImage + '")'};

        return <div className='HomePage' style={formStyle}>

            <div className='HomePage_header'>
                <h2>Frankenstein Inc.</h2>
                <h3>hi {getUser ? getUser.userName : 'default user'}</h3>
                <h3>your role is {getUser ? getUser.role : 'default role'}</h3>
                <Button bsSize='large'
                        onClick={() => logout()}>Logout</Button>
            </div>
        </div>;
    }
}
