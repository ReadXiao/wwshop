<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <link href="../../static/css/coupon.css" type="text/css" rel="stylesheet">
    <script src="../../static/userJs/UserCoupon.js"></script>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">

    <div class="wdgwc fl ml40">我的优惠卷</div>
    <div class="wxts fl ml20">温馨提示：优惠券在有效期内才有效哦，领取后请尽快使用</div>
    <div class="dlzc fr">
        <ul>
            <li><a href="../../index.jsp">首页</a></li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="coupon" >
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
                            <p>仅限购买${validCoupon.value}使用</p>
                        </div>
                    </div>
                    <div class="d3">
                        <p>【ww商城】有效期至${validCoupon.deadline}</p>
                        <button onclick="toUseCoupon('${validCoupon.catalogId}')">去使用</button>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>

