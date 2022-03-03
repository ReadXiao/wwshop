<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/goodsAdmin.js" type="text/javascript"></script>
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
                    <small>商品列表——————————————显示所有商品</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/toAddGoods">新增商品</a>
            </div>
            <div  class="col-md-4 column">
                <span id="state" hidden>2</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" id="first" class="li active" value="all"><a id="allGoodsSpu" href="#">全部商品</a></li>
                    <li role="presentation" id="second" class="li" value="0"><a id="OnlineGoodsSpu" href="#">线上商品</a></li>
                    <li role="presentation" id="third" class="li" value="1"><a id="unOnlineGoods" href="#">已下架</a></li>
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
                    <th class="col-md-1 column">商品编号</th>
                    <th class="col-md-1 column">商品图片</th>
                    <th class="col-md-2 column">商品名称</th>
                    <th class="col-md-1 column">商品价格</th>
                    <th class="col-md-2 column">商品描述</th>
                    <th class="col-md-2 column">上架时间</th>
                    <th class="col-md-2 column">商品状态</th>
                    <th class="col-md-1 column">操作</th>
                </tr>
                </thead>
                <%--商品从数据库中查询出来--%>
                <tbody id="allGoods">

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
