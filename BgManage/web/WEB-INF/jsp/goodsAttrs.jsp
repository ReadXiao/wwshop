<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/goodsAttr.js" type="text/javascript"></script>
    <style type="text/css">
        td{
            vertical-align: middle !important;
            font-family:  Verdana, Geneva, sans-serif;
            font-size: 14px;
        }
    </style>
</head>
<body>
<span id="json" hidden>${json}</span>
<span id="spuId" hidden>xxx</span>
<div class="container">
    <div class="row clearfix">
        <div class="col-md column">
            <div class="page-header">
                <h1>
                    <small>商品属性列表——————————————显示商品Sku</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" id="newSku" href="#">新增Sku</a>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>图片</th>
                    <th>属性</th>
                    <th>原价</th>
                    <th>优惠价</th>
                    <th>库存</th>
                    <th>上架时间</th>
                    <th>商品状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <%--商品从数据库中查询出来--%>
                <tbody id="allAttrs">

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
