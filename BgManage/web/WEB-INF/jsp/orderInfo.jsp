<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.4.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/orderInfo.js" type="text/javascript"></script>
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
            <div  class="col-md-7 column">
                <span hidden id="state">0</span>
                <ul class="nav nav-tabs">
                    <li role="presentation" class="li active" value="all"><a id="unPay" href="#">未付款</a></li>
                    <li role="presentation" class="li" value="0"><a id="unSendGoods" href="#">未发货</a></li>
                    <li role="presentation" class="li" value="1"><a id="unReceived" href="#">未收货</a></li>
                    <li role="presentation" class="li" value="1"><a id="already" href="#">已结束</a></li>
                </ul>
            </div>
            <div class="col-md-5 column">
                <form style="float: right">
                    <div class="col-md-8">
                        <input type="text" id="username" class="form-control" name="goodsName" placeholder="请输入要查询订单的用户名">
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
            <span hidden id="orders">${orderInfos}</span>
            <table class="table table-hover table-striped" >
                <thead>
                <tr>
                    <th class="col-md-1 column">订单编号</th>
                    <th class="col-md-1 column">用户名</th>
                    <th class="col-md-1 column">商品数量</th>
                    <th class="col-md-1 column">总价格</th>
                    <th class="col-md-2 column">创建时间</th>
                    <th class="col-md-2 column">付款时间</th>
                    <th class="col-md-1 column">订单状态</th>
                    <th class="col-md-1 column">配送方式</th>
                    <th class="col-md-1 column">快递单号</th>
                    <th class="col-md-1 column">操作</th>
                </tr>
                </thead>

                <tbody id="allOrderInfos">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
