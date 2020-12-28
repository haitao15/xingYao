import React from 'react'
import ReactDom from 'react-dom'
import {Button, Form, Menu} from 'antd';
import { MailOutlined, AppstoreOutlined, SettingOutlined } from '@ant-design/icons';
import {Link} from "react-router-dom";

const { SubMenu } = Menu;

class Home extends React.Component {
    state = {
        current: 'mail',
    };

    handleClick = e => {
        console.log('click ', e);
        this.setState({ current: e.key });
    };

    render() {
        const { current } = this.state;
        return (
            <Menu onClick={this.handleClick} selectedKeys={[current]} mode="horizontal"  style={{position: 'absolute', left: '50%', top: '50%', transform: 'translate(-50%, -50%)'}}>
                <Menu.Item key="login" icon={<SettingOutlined  />}>
                    <Button type="primary" htmlType="submit">
                        <Link to="/login">Login</Link>
                    </Button>
                </Menu.Item>

                <Menu.Item key="register" icon={<AppstoreOutlined  />}>
                    <Button type="primary" htmlType="submit">
                        <Link to="/register">Register</Link>
                    </Button>
                </Menu.Item>
            </Menu>
        );
    }
}

export default Home;