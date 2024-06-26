﻿
<h1 align="center">🐞unidbg-fetch-ismart🐞</h1>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Licence](https://img.shields.io/github/license/cxOrz/chaoxing-sign-cli?style=for-the-badge)

基于unidbg和springboot3实现的ismart签名ut在线生成服务


## 使用说明📖


### 云函数在线的api
> [https://service-4ft69f8n-1252377859.bj.tencentapigw.com.cn/release/ismart/ut?str=17856000000e8118e9fd56b6cca9e02f470bd8ca968&i=22](https://659921de0ebc41e58dd369f3184e8f7a.apig.cn-east-3.huaweicloudapis.com/ismart/ut?str=17856000000e8118e9fd56b6cca9e02f470bd8ca968&i=22)

## 打包部署 🛠

### 构建
将仓库克隆到本地

```bash
git clone https://github.com/251623126/unidbg-fetch-ismart.git
```
通过cd命令进入到unidbg-fetch-ismart根目录下，执行以下命令即可
  
```bash
mvn clean package
mvn package
```
>命令执行完成后在项目的unidbg-xxxx/target目录下，生成jar包文件

### 部署
#### 1、jar部署方式(推荐)
使用命令行执行：

```bash
java -jar target/unidbg-fetch-ismart-0.0.1.jar
```
### 本地API测试
> http://127.0.0.1:84/ismart/ut?str=17856000000e8118e9fd56b6cca9e02f470bd8ca968&i=22


## 已知问题❓

详见 [本项目的Bug](https://github.com/251623126/unidbg-fetch-ismart/labels/bug)

## Contribute

如果您也想参与到本项目的开发中，包括但不限于新功能的添加、文档的优化。

Fork之后提交Pr即可。

## 免责声明

本项目仅作为交流学习使用，通过本项目加深网络通信、接口编写、交互设计等方面知识的理解，请勿用作商业用途，任何人或组织使用项目中代码进行的任何违法行为与本人无关。
