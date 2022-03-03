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

    <!-- start danpin -->
    <div class="danpin center col-md-12">

        <div class="biaoti center" id="typeValue">${getCatalog.value}</div>
        <span hidden id="catalogId">${getCatalog.id}</span>
        <span hidden id="type">${type}</span>
        <div class="main col-md-12" id="goodsList">
            <c:forEach items="${allSpuGoods}" var="goods">
                <div class="mingxing fl mb20 col-md-3" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                    <div class="sub_mingxing"><a href="/detailGoods?spuId=${goods.id}" target="_blank"><img src="${goods.spuPic}" alt=""></a></div>
                    <div class="pinpai"><a href="/detailGoods?spuId=${goods.id}" target="_blank">${goods.goodsName}</a></div>
                    <div class="youhui">${goods.goodsDesc}</div>
                    <div class="jiage">${goods.spuPrice}元</div>
                </div>
            </c:forEach>
            <span hidden id="page">1</span>
            <div class="col-md-12" style="background-color: rgb(250,250,250);height: 30px"><span onclick="showMoreGoods()" style="line-height: 30px;color: #91999b;cursor:pointer">更多商品...</span></div>
        </div>
    </div>
</div>


<footer class="mt20 center">
    <div class="mt20">xxxxxxxxxxxxxxxxx肖宏武毕设xxxxxxxxxxxxxxxx</div>
    <div>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
    <div>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
</footer>

<!-- end danpin -->


</body>
</html>
