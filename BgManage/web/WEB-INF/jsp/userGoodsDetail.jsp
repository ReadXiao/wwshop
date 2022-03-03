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
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <script src="../../layui/layui.js"></script>
    <script src="../../static/userJs/userGoodsDetail.js" type="text/javascript"></script>
    <style type="text/css">
        .article-container {
            background-color: #ffffff;
            padding-top: 20px;
            width: 1024px;
            margin: 20px auto;
        }

        p {
            text-indent: 2em;
            font-size: 18px;
        }

        .NavLinks img {
            width: 100%;
            height: 100%;
        }

        .hitShowPic span {
            font-size: 15px;
            text-align: center;
        }

        /*以下评论的css*/
        .show_reply_list {
            margin-right: 1em;
            color: grey;
        }

        .comment_list {
            background-color: #ffffff;
            padding-top: 5px;
            width: 900px;
            margin: 0 auto;
        }

        .comment {
            width: 900px;
            margin-top: 10px;
        }

        .comment_content {
            clear: both;
            margin: 5px 50px;
            font-size: 16px;
            vertical-align: middle !important;
            font-family: Verdana, Geneva, sans-serif;
        }

        .imgdiv {
            width: 80px;
            height: 70px;
            float: left;

        }

        .imgcss {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .comment_name {
            margin-left: 10px;
            color: #3D9EEA;
            font-size: 16px;
            font-weight: bolder;
        }

        .layui-icon {
            font-size: 13px;
            color: grey;
        }

        .del {
            float: right;

        }

        .del_comment {
            margin-right: 50px;
        }
    </style>
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

    <div class="danpin center col-md-12">
        <!-- xiangqing -->
        <form action="post" method="">
            <div class="xiangqing">
                <div class="neirong col-md-12">
                    <div class="xiaomi6 fl">${goodsSpu.goodsName}</div>
                    <span id="spuId" hidden>${goodsSpu.id}</span>
                    <span id="userVIP" hidden>${userInfo.vip}</span>
                    <span id="catalogId" hidden>${goodsSpu.catalogId}</span>
                    <div class="clear"></div>
                </div>
            </div>

            <div class="jieshao mt20 col-md-12">
                <div class="left fl">
                    <%--<img src="../../image/liebiao_xiaomi6.jpg" height="560px" width="460px">--%>

                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox" id="detailPic">
                            <c:forEach items="${detailPics}" var="detailPics">
                                <div class="item">
                                    <img src="${detailPics.picUrl}" style="width: 420px;height: 500px;margin: 30px auto" alt="...">
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev" style="height: 60px; width: 60px;margin-top: 250px">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next" style="height: 60px; width: 60px;margin-top: 250px">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="right fr">
                    <div class="h3 ml20 mt20">${goodsSpu.goodsName}</div>
                    <div class="jianjie mr40 ml20 mt10">${goodsSpu.goodsDesc}
                    </div>
                    <div class="jiage ml20 mt10">${goodsSpu.spuPrice}元</div>
                    <div class="ft20 ml20 mt20">属性选择</div>
                    <div class="xzbb ml20 mt10">
                        <c:forEach items="${goodsSku}" var="goodsSku">
                            <div class="banben fl old" onclick="showAttrAndPrice('${goodsSpu.goodsName}','${goodsSku.attrValues}','${goodsSku.skuPrice}','${goodsSku.discountPrice}','${goodsSku.skuPic}',${goodsSku.id})">
                                <img src="${goodsSku.skuPic}" height="35px" width="30px" style="float: left">
                                <a style="float: left">
                                    <span>${goodsSku.attrValues}</span>
                                    <span>${goodsSku.skuPrice}元</span>
                                </a>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="xqxq mt20 ml20">
                        <div class="top1 mt10">
                            <div class="left1 fl" id="nameAttrs"></div>
                            <div class="right1 fr" id="disCountPrice" style="color: orange"></div>
                            <div class="right1 fr" id="normalPrice"></div>
                            <div class="clear"></div>
                        </div>
                        <div class="bot mt20 ft20 ftbc"><input type="button" value="-" style="width:20px" onclick="jian()"><input type="text" id="goodsNum" value="1" style="width:40px" disabled><input type="button" value="+" onclick="jia()" style="width:20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总计：<span id="totalPrice"></span>元</div>
                    </div>
                    <div class="xiadan ml20 mt20">
                        <input class="jrgwc" type="button" name="jrgwc" value="立即选购"/>
                        <input class="jrgwc" onclick="addCar()" type="button" name="jrgwc" value="加入购物车"/>
                    </div>
                </div>
                <div class="clear"></div>
            </div>

        </form>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>评论管理</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="article-container">
        <div class="comment_list">
            <h3 style="text-indent: 2em;">评论列表</h3>
            <hr>
            <c:forEach items="${goodsComment}" var="comments">
                <hr>
                <div class="comment">
                    <div class="imgdiv">
                        <img class="imgcss" src="${comments.userPic}"/>
                    </div>
                    <div class="conmment_details">
                        <div style="float:left;">
                            <span class="comment_name">${comments.userName} </span>     <span>${comments.commentTime}</span><p></p>
                            <span>${comments.goodsAttrs}</span>

                        </div>
                        <div class="del">
                            <span class="show_reply_list"> <c:choose>
                                <c:when test="${comments.grade == 0 }">
                                    非常差，非常不满意
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${comments.grade == 2 }">
                                        比较差，不满意
                                    </c:if>
                                    <c:if test="${comments.grade == 2 }">
                                        一般
                                    </c:if>
                                    <c:if test="${comments.grade == 3 }">
                                        还以，比较满意
                                    </c:if>
                                    <c:if test="${comments.grade == 3 }">
                                        非常满意
                                    </c:if>
                                </c:otherwise>
                            </c:choose></span>
                            <i class="layui-icon layui-icon-praise" style="font-size: 13px; color: #1E9FFF;">赞(${comments.likenum})</i>
                            <a class="del_comment" href="#" onclick="deleteComment(${comments.id},'${comments.spuId}')" data-id="1"> <i class="icon layui-icon"
                                                                                                                                        style="font-size: 13px; color: red;">删除</i></a>
                        </div>
                        <div class="comment_content">${comments.comment}
                            <img src="${comments.commentPics}" height="60px" width="60px">
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
