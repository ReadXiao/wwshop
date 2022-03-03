<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/monthSale.js" type="text/javascript"></script>
    <style type="text/css">
        #a_canvas{
            padding-top: 30px;
            padding-left: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>销售管理——————————————销售记录</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div  class="col-md-12 column">
                <span id="state" hidden>2</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" id="first" class="li active" value="all"><a id="monthSale" href="/toMonthSale">月销售</a></li>
                    <li role="presentation" id="second" class="li" value="0"><a id="catalogSale" href="/toCatalogSale">分类对比</a></li>
                    <li role="presentation" id="third" class="li" value="1"><a id="allSale" href="/toAllSale">全部商品</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="col-md-12 column">
        <span id="monthSaleCount" hidden>${month}</span>
            <canvas id="a_canvas" width="1000" height="600"></canvas>
    </div>
</div>
</body>
</html>
