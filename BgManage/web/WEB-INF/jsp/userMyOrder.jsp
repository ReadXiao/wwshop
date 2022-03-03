<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../static/css/style.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/userJs/index.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<!--最外层的布局容器-->
<div class="container">
    <!--LOGO部分-->
    <div class="row">
        <div class="col-md-9 hidden-sm hidden-xs">
            <img src="../../img/header.png"/>
        </div>
        <div class="col-md-3 col-sm-6 col-xs-6" style="line-height: 50px;height: 50px;">
            <div id="unLogin" style="display: block;line-height: 50px;height: 50px;">
                <a href="../../userLogin.jsp">登录</a>
                <a href="../../userRegist.jsp">注册</a>
                <span> | </span>
                <a href="#" onclick="toAddCar()">购物车</a>
                <span> | </span>
                <a href="#" onclick="toAddCoupon()">优惠券</a>
            </div>
            <div id="alreadyLogin" style="display: none;line-height: 50px;height: 50px; float: right">
                <a href="/mySelfInfo">个人中心</a>
                <span> | </span>
                <a href="#" onclick="toAddCar()">购物车</a>
                <span> | </span>
                <a href="#" onclick="toAddCoupon()">优惠券</a>
                <span> | </span>
                <a href="/userUnLogin">退出登录</a>
            </div>
        </div>
    </div>
    <!--导航栏部分-->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="catalogs">
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" id="search">
                    </div>
                    <button type="button" class="btn btn-default" id="findGoods">查找</button>
                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="grzxbj">
        <div class="selfinfo center">
            <div class="lfnav fl">
                <div class="ddzx">订单中心</div>
                <div class="subddzx">
                    <ul>
                        <li><a href="/myOrder" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                        <li><a href="">评价晒单</a></li>
                    </ul>
                </div>
                <div class="ddzx">个人中心</div>
                <div class="subddzx">
                    <ul>
                        <li><a href="/mySelfInfo">我的个人中心</a></li>
                        <li><a href="">优惠券</a></li>
                        <li><a href="">收货地址</a></li>
                    </ul>
                </div>
            </div>
            <div class="rtcont fr">
                <div class="ddzxbt">交易订单</div>
                <div class="ddxq">
                    <div class="ddspt fl"><img src="../../image/gwc_xiaomi6.jpg" alt=""></div>
                    <div class="ddbh fl">订单号:1705205643098724</div>
                    <div class="ztxx fr">
                        <ul>
                            <li>已发货</li>
                            <li>￥2499.00</li>
                            <li>2017/05/20 13:30</li>
                            <li><a href="">订单详情></a></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="ddxq">
                    <div class="ddspt fl"><img src="../../image/liebiao_hongmin4_dd.jpg" alt=""></div>
                    <div class="ddbh fl">订单号:170526435444865</div>
                    <div class="ztxx fr">
                        <ul>
                            <li>已发货</li>
                            <li>￥1999.00</li>
                            <li>2017/05/26 14:02</li>
                            <li><a href="">订单详情></a></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
</html>
