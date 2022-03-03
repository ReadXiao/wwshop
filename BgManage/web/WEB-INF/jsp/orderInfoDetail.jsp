<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/orderDetail.js" type="text/javascript"></script>
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
                    <small>订单列表——————————————显示所有订单</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 column">
                <table class="table">
                    <tr>
                        <td class="col-md-1 column">地址：</td>
                        <td class="col-md-11 column">${umsAddress.addressValue}</td>
                    </tr>
                    <tr>
                        <td class="col-md-1 column">电话：</td>
                        <td class="col-md-11 column">${umsAddress.telPhone}</td>
                    </tr>
                    <tr>
                        <td class="col-md-1 column">收件人：</td>
                        <td class="col-md-11 column">${umsAddress.consignee}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" >
                <thead>
                <tr>
                    <th class="col-md-2 column">商品编号</th>
                    <th class="col-md-2 column">商品名</th>
                    <th class="col-md-1 column">商品图片</th>
                    <th class="col-md-2 column">商品属性</th>
                    <th class="col-md-1 column">商品价格</th>
                    <th class="col-md-1 column">商品数量</th>
                    <th class="col-md-1 column">商品状态</th>
                    <th class="col-md-2 column">总价</th>
                </tr>
                </thead>
                <%--商品从数据库中查询出来--%>
                <tbody id="allOrderDetails">
                <c:forEach items="${orderDetails}" var="orderDetails">
                    <tr>
                        <td>${orderDetails.spuId}</td>
                        <td>${orderDetails.goodsName}</td>
                        <td><img src="${orderDetails.goodsPic}"  width='30px' height='40px'></td>
                        <td>${orderDetails.goodsAttrs}</td>
                        <td>${orderDetails.goodsPrice}</td>
                        <td>${orderDetails.goodsAmount}</td>
                        <td>
                            <c:choose>
                            <c:when test="${orderDetails.state == 0 }">
                               <span style="color: yellow">未付款</span>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${orderDetails.state == 1 }">
                                    <span style="color: red">未发货</span>
                                </c:if>
                                <c:if test="${orderDetails.state == 2 }">
                                    <span style="color: red">未收货</span>
                                </c:if>
                                <c:if test="${orderDetails.state == 3 }">
                                    <span style="color: green">已完成</span>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                         </td>
                        <td>${orderDetails.totalPrice}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="8"><span id="state" hidden>${state}</span><button class="btn btn-lg btn-primary" id="sendGoods" disabled="disabled" onclick="sendOrder(${orderId})">发货</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
