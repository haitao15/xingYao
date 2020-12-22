import React from 'react'
import ReactDom from 'react-dom'
import {Form, Input, Button, Checkbox} from 'antd';
import RegistrationForm from "./regster";
import {Link} from 'react-router-dom'

const layout = {
    labelCol: {span: 8},
    wrapperCol: {span: 16},
};
const tailLayout = {
    wrapperCol: {offset: 8, span: 16},
};


class Login extends React.Component {
    onFinish = values => {
        console.log('Success:', values);
    };

    onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
    };

    register = () => {
        // console.log('Failed111111');
        return <div>1111</div>
    };

    render() {
        return (
            <div style={{position: 'absolute', left: '50%', top: '50%', transform: 'translate(-50%, -50%)'}}>
                <div>
                    <Form
                        {...layout}
                        name="basic"
                        initialValues={{remember: true}}
                        onFinish={this.onFinish}
                        onFinishFailed={this.onFinishFailed}
                    >
                        <Form.Item
                            label="Username"
                            name="username"
                            rules={[{required: true, message: 'Please input your username!'}]}
                        >
                            <Input/>
                        </Form.Item>

                        <Form.Item
                            label="Password"
                            name="password"
                            rules={[{required: true, message: 'Please input your password!'}]}
                        >
                            <Input.Password/>
                        </Form.Item>

                        <Form.Item {...tailLayout} name="remember" valuePropName="checked">
                            <Checkbox>Remember me</Checkbox>
                        </Form.Item>

                        <Form.Item {...tailLayout}>
                            <Button type="primary" htmlType="submit" style={{margin: '0 10px'}}>
                                Submit
                            </Button>
                        </Form.Item>
                    </Form>
                </div>
                <div>
                        <Button type="primary" htmlType="submit" >
                            <Link to="/register">Register</Link>
                        </Button>

                </div>
            </div>
        );
    }
}

export default Login;