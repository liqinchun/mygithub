<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/13
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>top</title>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="css/fore/style.css" rel="stylesheet">
</head>
<style>
    body{
        font-size:12px;
        font-family:Arial;

    }
    a{
        color: #999;
    }
    .redColor{
        color: #C40000 !important;
    }
    nav.top{
        background-color: #f2f2f2;
        padding-top: 5px ;
        padding-bottom: 5px;
        border-bottom: 1px solid #e7e7e7;
    }

    nav.top span,nav.top.a{
        color: #999;
        margin: 0px 10px 0px 10px;
    }

    nav.top a:hover{
        color: #C40000;
        text-decoration: none;	    }
</style>

<body>
<nav class="top">
    <a href="#nowhere">
        <span class="glyphicon glyphicon-home redColor"></span>
        天猫首页</a>
    <span>
			    欢迎来到天猫
			</span>
    <a href="#nowhere">请登录</a>
    <a href="#nowhere">免费注册</a>
    <span class="">
				<a href="#nowhere">我的订单</a>
				<a herf="#nowhere">
					<span class=" glyphicon glyphicon-shopping-cart redColor" ></span>
					购物车<strong>0</strong>件
				</a>
			</span>

</nav>

</body>
</html>
