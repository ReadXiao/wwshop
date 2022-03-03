<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/userJs/userGoodsAddCar.js"></script>
    <style type="text/css">
        td {
            vertical-align: middle !important;
            font-family: Verdana, Geneva, sans-serif;
            font-size: 19px;
        }

        .delete:hover {
            color: red;
        }
    </style>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li><a href="../../index.jsp">首页</a></li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="gwcxqbj">
    <div class="gwcxd center">
        <!--购物车信息-->
        <input class="userVIP" value="${userInfo.vip}" type="hidden">
        <input class="userId" value="${userInfo.id}" type="hidden">
        <table class="table" style="background-color: white">
            <tbody id="allGoods">
            <tr style="height: 100px;line-height: 100px;text-align: center">
                <td class="col-md-1 column"><input type="checkbox" name="allSelect" id="allSelect">全选</td>
                <td class="col-md-1 column">图片</td>
                <td class="col-md-2 column">商品名</td>
                <td class="col-md-3 column">商品属性</td>
                <td class="col-md-1 column">价格</td>
                <td class="col-md-1 column">会员价</td>
                <td class="col-md-2 column">商品数量</td>
                <td class="col-md-1 column">操作</td>
            </tr>
            <c:forEach items="${allGoodsCar}" var="allGoods">
                <tr style="height: 100px;line-height: 100px;text-align: center" class="goods">
                    <td><input type="checkbox" name="goods" class="selectGoods"></td>
                    <td class="pic">
                        <img src="${allGoods.skuPic}" style="width: 50px;height: 60px">
                        <span hidden class="skuPic">${allGoods.skuPic}</span>
                    </td>
                    <td class="goodsName">${allGoods.goodsName}</td>
                    <td class="goodsAttrs">${allGoods.goodsAttrs}</td>
                    <td class="skuPrice">${allGoods.skuPrice}</td>
                    <td style="color: orange" class="discountPrice">${allGoods.discountPrice}</td>
                    <td class="num">
                        <input type="button" value="-" style="width: 20px" class="jian">
                        <input type="text" value="${allGoods.goodsAmount}" style="width: 40px" class="goodsNum"
                               disabled>
                        <input type="button" value="+" style="width: 20px" class="jia">
                        <input type="hidden" value="${allGoods.spuId}" class="spuId">
                        <input type="hidden" value="${allGoods.skuId}" class="skuId">
                        <input type="hidden" value="${allGoods.catalogId}" class="catalogId">
                    </td>
                    <td class="carId">
                        <span class="delete glyphicon glyphicon-trash" aria-hidden="true"></span>
                        <input type="hidden" value="${allGoods.id}" class="addCarId">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="../../index.jsp">继续购物</a></li>
                <li>|</li>
                <li>共<span id="totalGoods">0</span>件商品，已选择<span id="alreadyGoods">0</span>件</li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">合计（不含运费）：<span id="totalPrice">0.00</span>元</div>
            <div class="jsanniu fr"><input class="jsan" type="button" name="jiesuan" value="去结算"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>

</div>


<!-- footer -->
<footer class="center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

</body>
</html>
