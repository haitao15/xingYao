const path = require('path')
const HtmlWebPackPlugin = require('html-webpack-plugin')    //导入在内存中自动生成index页面的插件

const htmlPlugin = new HtmlWebPackPlugin({
    template: path.join(__dirname, './src/index.html'), //源文件
    filename: 'index.html'                               //生成的内存中首页名称
})

//向外暴露一个打包的配置对象；因为webpack基于Node构建，支持所有Node APL和语法
module.exports = {
    mode: "development",
    plugins: [
        htmlPlugin
    ],
    module: {
        rules: [
            {
                test: /\.js|jsx$/,
                use: 'babel-loader',
                exclude: /node_modules/
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(ttf|eot|svg|woff(2)?)(\?[a-z0-9=&.]+)?$/,
                use: "file-loader?name=assets/[name].[ext]"
            }
        ]
    }
}
