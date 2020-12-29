import React from 'react';
import {HashRouter, Route, Switch} from 'react-router-dom';
import Login from "../common/login";
import RegistrationForm from "../common/regster";
import UserHome from "../user/UserHome";
import AdminHome from "../admin/AdminHome";

const BasicRoute = () => (
    <HashRouter>
        <Switch>
            <Route exact path="/" component={Login}/>
            <Route exact path="/login" component={Login}/>
            <Route exact path="/register" component={RegistrationForm}/>
            <Route exact path="/userHome" component={UserHome}/>
            <Route exact path="/adminHome" component={AdminHome}/>
        </Switch>
    </HashRouter>
);


export default BasicRoute;