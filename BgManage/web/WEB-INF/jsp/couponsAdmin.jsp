<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css" type="text/css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <link href="../../static/css/coupon.css" type="text/css" rel="stylesheet">
    <script src="../../static/js/couponAdmin.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>优惠卷列表——————————————显示所有优惠卷</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="/toAddCouponPage">新增优惠卷</a>
            </div>
            <div class="col-md-8 column">
                <span id="state" hidden>2</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" id="first" class="li active" value="all"><input type="hidden" value="1"><a id="validCoupon"
                                                                                        href="#">有效卷</a></li>
                    <li role="presentation" id="second" class="li" value="0"><input type="hidden" value="2"><a id="unValidCoupon" href="#">过期卷</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="coupon" >
        <p class="tt">优惠卷管理<a>×</a></p>
        <ul id="allCoupons">
            <c:forEach items="${validCoupon}" var="validCoupon">
                <li>
                    <div class="cone">
                        <div class="d2">${validCoupon.value}券</div>
                        <div class="d1">
                            <div>
                                <span>${validCoupon.discountPrice}</span>
                                <span>元</span>
                            </div>
                            <div>
                                <p>满${validCoupon.minPrice}元可用</p>
                                <p>仅限购买${validCoupon.value}使用：剩余${validCoupon.count}张</p>
                            </div>
                        </div>
                        <div class="d3">
                            <p>【ww商城】有效期至${validCoupon.deadline}</p>
                            <button onclick="cancelCoupon(${validCoupon.id})">撤销此卷</button>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
