<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../static/js/jquery.js"></script>
    <style type="text/css">
        *{margin:0;padding:0;list-style-type:none;}
        body{background:#fff;color:#333;font-family:"Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;font-size:0.9em;}
        #container{width:900px;margin:50px auto;}
        #chart, #chartData{border:1px solid #333;background:#ebedf2 url("../../images/gradient.png") repeat-x 0 0;}
        #chart{display:block;margin:0 0 50px 0;float:left;cursor:pointer;}
        #chartData{width:200px;margin:0 40px 0 0;float:right;border-collapse:collapse;box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-moz-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-webkit-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);background-position:0 -100px;}
        #chartData th, #chartData td{padding:0.5em;border:1px dotted #666;text-align:left;}
        #chartData th{border-bottom:2px solid #333;text-transform:uppercase;}
        #chartData td{cursor:pointer;}
        #chartData td.highlight{background:#e8e8e8;}
        #chartData tr:hover td{background:#f0f0f0;}
    </style>

    <script src="../../static/js/jquery.min.js"></script>
    <!--[if IE]>
    <script src="../../static/js/excanvas.js"></script>
    <![endif]-->

    <script type="text/javascript" src="../../static/js/pieChart.js"></script>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/catalogSale.js" type="text/javascript"></script>
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
                    <li role="presentation" id="first" class="li" value="all"><a id="monthSale" href="/toMonthSale">月销售</a></li>
                    <li role="presentation" id="second" class="li active" value="0"><a id="catalogSale" href="/toCatalogSale">分类对比</a></li>
                    <li role="presentation" id="third" class="li" value="1"><a id="allSale" href="/toAllSale">全部商品</a></li>
                </ul>
            </div>
        </div>
    </div>

<div id="container">

    <canvas id="chart" width="600" height="500"></canvas>
    <span id="saleSum" hidden>${saleSums}</span>
    <table id="chartData">
        <tr>
            <th>商品类别</th><th>销售总额</th>
        </tr>
        <c:forEach var="saleSum" items="${saleSums}">
            <tr style="color:${saleSum.color}">
                <td>${saleSum.catalogValue}</td><td>${saleSum.totalSale}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>