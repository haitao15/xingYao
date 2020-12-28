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

const headers = {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:8080',
    'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT, DELETE',
    'Access-Control-Allow-Credentials': true
};

class Login extends React.Component {
    onFinish = values => {
        console.log(values);
        fetch('http://localhost:8080/login', {
            // post提交
            method: "POST",
            mode: 'cors',
            // credentials: 'include',
            headers: headers,
            body: JSON.stringify(values)//把提交的内容转字符串
        }).then(res =>
            res.json()
        ).then(data => {
            console.log(data)
        })
    };

    onFinishFailed = errorInfo => {
        console.log('Failed:', errorInfo);
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
                            label="name"
                            name="name"
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
                            <Button type="primary" htmlType="submit">
                                <Link to="/register">Register</Link>
                            </Button>
                        </Form.Item>
                    </Form>
                </div>
                <div>


                </div>
            </div>
        );
    }
}

export default Login;