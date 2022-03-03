<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-3.4.1.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <script src="static/userJs/index.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<!--最外层的布局容器-->
<div class="container">
    <!--LOGO部分-->
    <div class="row">
        <div class="col-md-9 hidden-sm hidden-xs">
            <img src="img/header.png"/>
        </div>
        <div class="col-md-3 col-sm-6 col-xs-6" style="line-height: 50px;height: 50px;">
            <div id="unLogin" style="display: block;line-height: 50px;height: 50px;">
                <a href="userLogin.jsp">登录</a>
                <a href="userRegist.jsp">注册</a>
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


    <!--轮播图-->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="1000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/1.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="img/2.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="img/3.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!--最新商品-->
    <div class="row">
        <div class="col-md-12">
            <h3>最新商品<img src="images/title2.jpg"/></h3>
        </div>
    </div>


    <!--商品部分-->
    <div class="row">
        <!--左边大图部分-->
        <div class="col-md-2 hidden-sm hidden-xs" style="height: 480px;">
            <img src="products/hao/big01.jpg" width="100%" height="100%"/>
        </div>
        <!--
            右边商品项部分
        -->
        <div class="col-md-10">
            <!--投影神券来袭-->
            <div class="col-md-6 hidden-sm hidden-xs" style="height: 240px;">
                <img src="products/hao/middle01.jpg" style="width: 100%;"/>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small01.jpg" style="max-width: 80%;"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small02.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small03.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small04.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small05.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small06.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small07.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small08.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small09.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>


        </div>
    </div>
    <!--LOGO部分-->
    <div class="row">
        <div class="col-md-12">
            <img src="products/hao/ad.jpg" width="100%"/>
        </div>
    </div>

    <!--最新商品-->
    <div class="row">
        <div class="col-md-12">
            <h3>最新商品<img src="images/title2.jpg"/></h3>
        </div>
    </div>
    <!--商品部分-->
    <div class="row">
        <!--左边大图部分-->
        <div class="col-md-2 hidden-sm hidden-xs" style="height: 480px;">
            <img src="products/hao/big01.jpg"/>
        </div>
        <!--
            右边商品项部分
        -->
        <div class="col-md-10">
            <!--投影神券来袭-->
            <div class="col-md-6 hidden-sm hidden-xs" style="height: 240px;">
                <img src="products/hao/middle01.jpg"/>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small09.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small08.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small07.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small06.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small05.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small04.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small03.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small02.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>

            <div class="col-md-2 col-sm-4 col-xs-6" style="text-align: center;height: 240px;">
                <img src="products/hao/small01.jpg"/>
                <p>微波炉</p>
                <p style="color: red;">$998</p>
            </div>


        </div>
    </div>


    <!-- footer -->
    <div class="row">
        <div class="col-md-12">
            <img src="img/footer.jpg" width="100%"/>
        </div>
    </div>


    <div style="text-align: center;">

        <a href="#">关于我们</a>
        <a href="#">联系我们</a>
        <a href="#">招贤纳士</a>
        <a href="#">法律声明</a>
        <a href="#">友情链接</a>
        <a href="#">支付方式</a>
        <a href="#">配送方式</a>
        <a href="#">服务声明</a>
        <a href="#">广告声明</a>

        <br/>

        2020肖宏武毕业设计
    </div>

</div>
</body>
</html>
