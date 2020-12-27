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
            <Route exact path="/register" component={RegistrationForm}/>
            <Route exact path="/AdminHome" component={AdminHome}/>
            <Route exact path="/UerHome" component={UserHome}/>
        </Switch>
    </HashRouter>
);


export default BasicRoute;