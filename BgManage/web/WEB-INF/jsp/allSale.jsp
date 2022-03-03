<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/allSale.js" type="text/javascript"></script>
    <style type="text/css">
        td{
            vertical-align: middle !important;
            font-family:  Verdana, Geneva, sans-serif;
            font-size: 14px;
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
            <div  class="col-md-7 column">
                <span id="state" hidden>2</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" id="first" class="li" value="all"><a id="monthSale" href="/toMonthSale">月销售</a></li>
                    <li role="presentation" id="second" class="li" value="0"><a id="catalogSale" href="/toCatalogSale">分类对比</a></li>
                    <li role="presentation" id="third" class="li active" value="1"><a id="allSale" href="/toAllSale">全部商品</a></li>
                </ul>
            </div>
            <div class="col-md-5 column">
                <form style="float: right">
                    <div class="col-md-8">
                        <input type="text" id="goodsName" class="form-control" name="goodsName" placeholder="请输入要查询的商品名称">
                    </div>
                    <div class="col-md-1">
                        <input id="chaXun" type="button" class="btn btn-default" value="查询">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" >
                <thead>
                <tr>
                    <th class="col-md-2 column">商品编号</th>
                    <th class="col-md-2 column">商品名称</th>
                    <th class="col-md-2 column">商品图片</th>
                    <th class="col-md-2 column">商品属性</th>
                    <th class="col-md-2 column">销售数</th>
                    <th class="col-md-2 column">销售额</th>
                </tr>
                </thead>
                <tbody id="allGoodsSaleDetail">
                    <c:forEach items="${allSaleDetail}" var="allSales">
                        <tr>
                            <td>${allSales.spuId}</td>
                            <td>${allSales.goodsName}</td>
                            <td><img src="${allSales.goodsPic}" width='30px' height='40px'></td>
                            <td>${allSales.goodsAttrs}</td>
                            <td>${allSales.count}</td>
                            <td>${allSales.saleSum}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
