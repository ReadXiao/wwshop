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

    <!-- self_info -->
    <div class="grzxbj">
        <div class="selfinfo center">
            <div class="lfnav fl">
                <div class="ddzx">订单中心</div>
                <div class="subddzx">
                    <ul>
                        <li><a href="/myOrder">我的订单</a></li>
                        <li><a href="">评价晒单</a></li>
                    </ul>
                </div>
                <div class="ddzx">个人中心</div>
                <div class="subddzx">
                    <ul>
                        <li><a href="/mySelfInfo" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                        <li><a href="">优惠券</a></li>
                        <li><a href="">收货地址</a></li>
                    </ul>
                </div>
            </div>
            <div class="rtcont fr">
                <div class="grzlbt ml40">我的资料</div>
                <div class="subgrzl ml40"><span>昵称</span><span>啦啦维吉尔</span><span><a href="">编辑</a></span></div>
                <div class="subgrzl ml40"><span>手机号</span><span>15669097417</span><span><a href="">编辑</a></span></div>
                <div class="subgrzl ml40"><span>密码</span><span>************</span><span><a href="">编辑</a></span></div>
                <div class="subgrzl ml40"><span>个性签名</span><span>一支穿云箭，千军万马来相见！</span><span><a href="">编辑</a></span>
                </div>
                <div class="subgrzl ml40"><span>我的爱好</span><span>游戏，音乐，旅游，健身</span><span><a href="">编辑</a></span></div>
                <div class="subgrzl ml40"><span>收货地址</span><span>浙江省杭州市江干区19号大街571号</span><span><a href="">编辑</a></span>
                </div>

            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
</html>
