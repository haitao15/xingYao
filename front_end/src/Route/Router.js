import React from 'react';
import {HashRouter, Route, Switch} from 'react-router-dom';
import Login from "../user/login";
import RegistrationForm from "../user/regster";


const BasicRoute = () => (
    <HashRouter>
        <Switch>
            <Route exact path="/" component={Login}/>
            <Route exact path="/register" component={RegistrationForm}/>
        </Switch>
    </HashRouter>
);


export default BasicRoute;