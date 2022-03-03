<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../static/css/css.css"/>
    <script src="../../static/userJs/userPayPage.js"></script>
    <style type="text/css">
        td {
            vertical-align: middle !important;
            font-family: Verdana, Geneva, sans-serif;
            font-size: 19px;
        }
    </style>
<body>
<div class="banner_x center">
    <div class="wdgwc fl ml40">立即付款</div>
    <div class="wxts fl ml20">温馨提示：请在一定的时间内完成付款哦!</div>
    <span class="userId" hidden>${userId}</span>
    <span class="orderId" hidden>${orderId}</span>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="Caddress">
    <div class="open_new">
        <button class="open_btn" onclick="javascript:onclick_open();">使用新地址</button>
    </div>
    <c:forEach items="${addresses}" var="addresses">
        <div class="add_mi">
            <span hidden class="addressId">${addresses.id}</span>
            <p style="border-bottom:1px dashed #ccc;line-height:28px;" class="consignee">${addresses.consignee}</p>
            <p class="adds"><span class="addressValue">${addresses.addressValue}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="telPhone">${addresses.telPhone}</span></p>
        </div>
    </c:forEach>
</div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <table class="table" style="background-color: rgb(245, 245, 245);text-align: center">
            <tr>
                <td>图片</td>
                <td>名称</td>
                <td>属性</td>
                <td>价格</td>
                <td>数量</td>
            </tr>
            <c:forEach items="${orderDetails}" var="orderDetails">
                <tr style="height: 100px;line-height: 100px;text-align: center" class="goods">
                    <td><img src="${orderDetails.goodsPic}" style="width: 50px;height: 60px"></td>
                    <td>${orderDetails.goodsName}</td>
                    <td>${orderDetails.goodsAttrs}</td>
                    <td>${orderDetails.goodsPrice}</td>
                    <td>${orderDetails.goodsAmount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="banner_x center">
    <div class="wdgwc ml40">使用优惠卷</div>
    <c:forEach items="${userCoupons}" var="userCoupons">
        <div class="userCoupon fl old1">
            <span hidden class="userCouponId">${userCoupons.id}</span>
            <span>${userCoupons.value}</span>：
            满<span class="minPrice">${userCoupons.minPrice}</span>元，
            减<span class="discountPrice">${userCoupons.discountPrice}</span>元。
        </div>
    </c:forEach>
    <div class="clear"></div>
</div>

<div class="jieshao mt20 col-md-12">
    <div class="xzbb ml20 mt10">
        <div class="shopping_content">
            <div class="" style="width: 100%; text-align: right; margin-top: 10px;">
                <div class="div_outMumey" style="float: left;">
                    总价：<span class="out_momey" id="totalPrice">${totalPrice}</span>
                </div>
                <button class="btn_closing">结算</button>
            </div>
        </div>
    </div>
</div>
<div class="shade">
</div>
<div class="shade_content">
    <div class="col-xs-12 shade_colse">
        <button onclick="javascript:onclick_close();">x</button>
    </div>
    <div class="nav shade_content_div">
        <div class="col-xs-12 shade_title">
            新增收货地址
        </div>
        <div class="col-xs-12 shade_from">
            <form action="" method="post">
                <div class="col-xs-12">
                    <span class="span_style">详细地址</span>
                    <input class="input_style" type="" name="" id="address" value=""
                           placeholder="&nbsp;&nbsp;请输入您的详细地址"/>
                </div>
                <div class="col-xs-12">
                            <span class="span_style"
                                  class="span_sty">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
                    <input class="input_style" type="" name="" id="name_" value=""
                           placeholder="&nbsp;&nbsp;请输入您的姓名"/>
                </div>
                <div class="col-xs-12">
                    <span class="span_style">手机号码</span>
                    <input class="input_style" type="" name="" id="phone" value=""
                           placeholder="&nbsp;&nbsp;请输入您的手机号码"/>
                </div>
                <div class="col-xs-12">
                    <input class="btn_remove" type="button" onclick="javascript:onclick_close();" value="取消"/>
                    <input type="button" class="sub_set" id="insertAddress" value="增加"/>
                    <input type="button" class="sub_set" id="updateAddress" value="修改"/>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
